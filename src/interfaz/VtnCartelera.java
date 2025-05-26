/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author jrme0
 */
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class VtnCartelera
{

    private Stage stage;
    
    private MediaView mediaView;
    private MediaPlayer currentPlayer;
    private HBox controlsBox;

    public void mostrar()
    {
        Platform.runLater(() ->
        {
            try
            {
                
                if (stage != null && stage.isShowing()) 
                {
                    stage.toFront(); // Ya está abierta, solo la traemos al frente
                    return;
                }
                
                BorderPane root = new BorderPane();

                // HBox para el botón de regresar (parte superior derecha)
                HBox topBox = new HBox();
                topBox.setPadding(new Insets(10));
                topBox.setSpacing(10);
                topBox.setStyle("-fx-background-color: #dddddd;");
                topBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
                Button regresarButton = new Button("⏎ Regresar al menú");
                
                regresarButton.setOnAction(e -> ((Stage) regresarButton.getScene().getWindow()).close());
                topBox.getChildren().add(regresarButton);

                // Scroll con las películas
                ScrollPane scrollPane = new ScrollPane();
                HBox contenedorPeliculas = new HBox(20);
                contenedorPeliculas.setPadding(new Insets(10));
                scrollPane.setContent(contenedorPeliculas);
                scrollPane.setFitToHeight(true);

                mediaView = new MediaView();
                mediaView.setFitWidth(640);
                mediaView.setFitHeight(360);
                mediaView.setPreserveRatio(true);

                controlsBox = new HBox(10);
                controlsBox.setPadding(new Insets(10));
                controlsBox.setAlignment(javafx.geometry.Pos.CENTER);

                VBox centerBox = new VBox(10);
                centerBox.setPadding(new Insets(10));
                centerBox.setAlignment(javafx.geometry.Pos.CENTER);
                centerBox.getChildren().addAll(mediaView, controlsBox);

                root.setTop(topBox);  // ahora el botón está arriba
                root.setCenter(centerBox);
                root.setBottom(scrollPane);  // y las películas abajo

                List<Pelicula> peliculas = cargarPeliculasDesdeBD();

                for (Pelicula pelicula : peliculas)
                {
                    VBox contenedor = new VBox(5);
                    contenedor.setPadding(new Insets(5));
                    contenedor.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-background-color: #f9f9f9;");
                    ImageView imagen = new ImageView(pelicula.getImagen());
                    imagen.setFitHeight(200);
                    imagen.setPreserveRatio(true);

                    Label titulo = new Label("🎬 " + pelicula.getTitulo());
                    titulo.setStyle("-fx-font-weight: bold");

                    Label duracion = new Label("⏱ Duración: " + pelicula.getDuracion());
                    Label idioma = new Label("🗣 Idioma: " + pelicula.getIdioma());
                    Label clasificacion = new Label("🔞 Clasificación: " + pelicula.getClasificacion());
                    Label sinopsis = new Label("📖 Sinopsis: " + pelicula.getSinopsis());
                    Label reparto = new Label("🎭 Reparto: " + pelicula.getReparto());
                    Label estreno = new Label("📅 Estreno: " + pelicula.getFechaEstreno());

                    imagen.setOnMouseClicked(e -> reproducirTrailer(pelicula.getVideoFile()));

                    contenedor.getChildren().addAll(imagen, titulo, duracion, idioma, clasificacion, sinopsis, reparto, estreno);
                    contenedorPeliculas.getChildren().add(contenedor);
                }

                Scene scene = new Scene(root, 1000, 800);
                stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Cartelera de Películas");
                //stage.setOnCloseRequest(e -> stage = null);
                stage.show();              
                stage.setOnCloseRequest(e -> {
                e.consume(); // Evita que se cierre completamente
                    if (currentPlayer != null) 
                        {
                            currentPlayer.stop();
                            currentPlayer.dispose();
                        }
                    stage.hide();
                });
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });

    }

    private void reproducirTrailer(File videoFile)
    {
        if (currentPlayer != null)
        {
            currentPlayer.stop();
        }

        Media media = new Media(videoFile.toURI().toString());
        currentPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(currentPlayer);

        Button playButton = new Button("▶");
        playButton.setOnAction(e -> currentPlayer.play());

        Button pauseButton = new Button("⏸");
        pauseButton.setOnAction(e -> currentPlayer.pause());

        Button stopButton = new Button("⏹");
        stopButton.setOnAction(e -> currentPlayer.stop());

        Button rewindButton = new Button("⏪");
        rewindButton.setOnAction(e -> currentPlayer.seek(currentPlayer.getCurrentTime().subtract(Duration.seconds(5))));

        Button forwardButton = new Button("⏩");
        forwardButton.setOnAction(e -> currentPlayer.seek(currentPlayer.getCurrentTime().add(Duration.seconds(5))));

        controlsBox.getChildren().setAll(playButton, pauseButton, stopButton, rewindButton, forwardButton);

        currentPlayer.play();
    }

    private List<Pelicula> cargarPeliculasDesdeBD()
    {
        List<Pelicula> peliculas = new ArrayList<>();

        String url = "jdbc:oracle:thin:@25.50.80.247:1521/xepdb1";
        String user = "equipoFBD";
        String password = "10714223";

        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT NOMBRE_PELICULA, DURACION, ID_IDIOMA, ID_CLASIFICACION, SIPNOSIS, REPARTO, FECHA_ESTRENO, FOTO_REPRESENTATIVA, TRAILER FROM PELICULA"))
        {

            while (rs.next())
            {
                String titulo = rs.getString("NOMBRE_PELICULA");
                String duracion = rs.getString("DURACION");
                String idioma = rs.getString("ID_IDIOMA");
                String clasificacion = rs.getString("ID_CLASIFICACION");
                String sinopsis = rs.getString("SIPNOSIS");
                String reparto = rs.getString("REPARTO");
                //Date fecha = rs.getDate("FECHA_ESTRENO");
                java.sql.Date fecha = rs.getDate("FECHA_ESTRENO");
                String fechaEstreno = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
                InputStream imagenStream = rs.getBinaryStream("FOTO_REPRESENTATIVA");
                InputStream videoStream = rs.getBinaryStream("TRAILER");

                Image imagen = new Image(imagenStream);
                File tempVideo = File.createTempFile("trailer_", ".mp4");
                tempVideo.deleteOnExit();

                try (OutputStream os = new FileOutputStream(tempVideo))
                {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = videoStream.read(buffer)) != -1)
                    {
                        os.write(buffer, 0, bytesRead);
                    }
                }

                peliculas.add(new Pelicula(titulo, duracion, idioma, clasificacion, sinopsis, reparto, fechaEstreno, imagen, tempVideo));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return peliculas;
    }

    public static class Pelicula
    {

        private final String titulo, duracion, idioma, clasificacion, sinopsis, reparto, fechaEstreno;
        private final Image imagen;
        private final File videoFile;

        public Pelicula(String titulo, String duracion, String idioma, String clasificacion, String sinopsis, String reparto, String fechaEstreno, Image imagen, File videoFile)
        {
            this.titulo = titulo;
            this.duracion = duracion;
            this.idioma = idioma;
            this.clasificacion = clasificacion;
            this.sinopsis = sinopsis;
            this.reparto = reparto;
            this.fechaEstreno = fechaEstreno;
            this.imagen = imagen;
            this.videoFile = videoFile;
        }

        public String getTitulo()
        {
            return titulo;
        }

        public String getDuracion()
        {
            return duracion;
        }

        public String getIdioma()
        {
            return idioma;
        }

        public String getClasificacion()
        {
            return clasificacion;
        }

        public String getSinopsis()
        {
            return sinopsis;
        }

        public String getReparto()
        {
            return reparto;
        }

        public String getFechaEstreno()
        {
            return fechaEstreno;
        }

        public Image getImagen()
        {
            return imagen;
        }

        public File getVideoFile()
        {
            return videoFile;
        }
    }
}
