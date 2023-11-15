package com.example.formapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FormApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FormApplication.class.getResource("form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Logging Application");
        stage.setScene(scene);
        stage.setMaxHeight(400);
        stage.setMaxWidth(420);
        stage.setMinHeight(400);
        stage.setMinWidth(420);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}