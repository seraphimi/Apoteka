package com.asss.apoteka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Apoteka extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Application.setUserAgentStylesheet("dracula.css");
        FXMLLoader fxmlLoader = new FXMLLoader(Apoteka.class.getResource("ApotekaLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);


        stage.setTitle("Apoteka");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
