package com.example.formapp;

import javafx.scene.control.Alert;

public class DialogComponentInitializer {
    public static void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
