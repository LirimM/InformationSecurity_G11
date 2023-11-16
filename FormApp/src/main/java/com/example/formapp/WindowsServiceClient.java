package com.example.formapp;

import java.io.OutputStream;
import java.net.Socket;

public class WindowsServiceClient {
    //Predefined constants required for a successful connection
    private static final String SERVICE_HOST = "localhost";
    private static final int SERVICE_PORT = 12345;

    public static void logData(String username, String password) {
        try {
            Socket socket = new Socket(SERVICE_HOST, SERVICE_PORT);
            OutputStream outputStream = socket.getOutputStream();

            //Send formatted data to the server via socket
            String data = "Username: " + username + " Password: " + password;
            outputStream.write(data.getBytes());

            //Close stream & output socket after the operation is complete
            outputStream.close();
            socket.close();
            DialogComponentInitializer.showInfoDialog("Success!","The submitted data is logged in Windows Application Logs!");
        } catch (Exception e) {
            DialogComponentInitializer.showErrorDialog("Login error!","Log in failed!\nPlease check if the background service is running.");
        }
    }
}
