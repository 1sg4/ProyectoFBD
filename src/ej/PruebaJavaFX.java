/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author jrme0
 */
public class PruebaJavaFX extends Application
{
    public void start(Stage stage)
    {
        // Ruta local al video (puedes usar URL si está en línea)
        String videoPath = "file:///C:/Users/camac/Videos/prbbd/hola.mp4";

        Media media = new Media(videoPath);
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);

        mediaView.fitWidthProperty().bind(stage.widthProperty());
        mediaView.fitHeightProperty().bind(stage.heightProperty());
        mediaView.setPreserveRatio(true);

        player.setVolume(1.0);
        
        StackPane root = new StackPane(mediaView);
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Reproductor de Tráiler");
        stage.setScene(scene);
        stage.show();

        player.play();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
