package com.example.formapp;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FormController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLogInClickHandler() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        WindowsServiceClient.logData(username, password);
    }
}