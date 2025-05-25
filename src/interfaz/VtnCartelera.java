/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author trist
 */
public class VtnCartelera extends Application 
{

 
    private static final String DB_URL = "jdbc:oracle:thin:@//25.50.80.247:1521/xepdb1";
    private static final String DB_USER = "EQUIPOFBD";
    private static final String DB_PASS = "10714223";

    private MediaView mediaView;
    private MediaPlayer currentPlayer;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox imageGallery = new HBox(10);
        ScrollPane scrollPane = new ScrollPane(imageGallery);
        scrollPane.setFitToHeight(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        mediaView = new MediaView();
        mediaView.setFitWidth(800);
        mediaView.setPreserveRatio(true);

        root.setTop(scrollPane);
        root.setCenter(mediaView);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT CVE_PELICULA, NOMBRE_PELICULA, FOTO_PRESENTA, TRAILER FROM PELICULA";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("NOMBRE_PELICULA");
                Blob imagenBlob = rs.getBlob("FOTO_PRESENTA");
                Blob trailerBlob = rs.getBlob("TRAILER");

                if (imagenBlob != null && trailerBlob != null) {
                    InputStream imgStream = imagenBlob.getBinaryStream();
                    Image img = new Image(imgStream);
                    ImageView imageView = new ImageView(img);
                    imageView.setFitHeight(150);
                    imageView.setPreserveRatio(true);

                    // Guardar el video en archivo temporal
                    File trailerFile = File.createTempFile("trailer_", ".mp4");
                    try (OutputStream out = new FileOutputStream(trailerFile);
                         InputStream in = trailerBlob.getBinaryStream()) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    }

                    // Evento clic para reproducir video
                    imageView.setOnMouseClicked(e -> playVideo(trailerFile));

                    imageGallery.getChildren().add(imageView);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Cartelera de Películas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playVideo(File videoFile) {
        if (currentPlayer != null) {
            currentPlayer.stop();
        }
        Media media = new Media(videoFile.toURI().toString());
        currentPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(currentPlayer);
        currentPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
