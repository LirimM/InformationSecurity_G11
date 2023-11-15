package com.example.formapp;

public class WindowsServiceClient {
    private static final String SERVICE_HOST = "localhost";
    private static final int SERVICE_PORT = 9876; //needs to be the same as the server port

    public static void logData(String username, String password) {
        try {
            //TODO
            System.out.println(username + " - " + password);
            throw new Exception();
        } catch (Exception e) {
            DialogComponentInitializer.showErrorDialog("Login error!","Log in failed!\nPlease check if the background service is running.");
        }
    }
}
