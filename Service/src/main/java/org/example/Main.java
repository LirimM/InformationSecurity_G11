package org.example;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.WinNT;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);  // Listen on port 12345
            System.out.println("Service is running. Waiting for data...");

            while (true) {
                Socket socket = serverSocket.accept();
                handleClientRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClientRequest(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            if (bytesRead > 0) {
                String receivedData = new String(buffer, 0, bytesRead);
                logDataToEventViewer(receivedData);
                System.out.println("Received data: " + receivedData);
            }

            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logDataToEventViewer(String data) {
        WinNT.HANDLE hEventLog = Advapi32.INSTANCE.RegisterEventSource(null, "Application");

        if (hEventLog != null) {
            // Log the event
            boolean success = Advapi32.INSTANCE.ReportEvent(
                    hEventLog,
                    WinNT.EVENTLOG_INFORMATION_TYPE,
                    0,
                    0,
                    null,
                    1,
                    0,
                    new String[]{data},
                    null
            );

            if (success) {
                System.out.println("Event logged successfully.");
            } else {
                int errorCode = Native.getLastError();
                System.out.println("Failed to log event. Error code: " + errorCode);
            }

            Advapi32.INSTANCE.DeregisterEventSource(hEventLog);
        } else {
            int errorCode = Native.getLastError();
            System.out.println("Failed to register event source. Error code: " + errorCode);
        }
    }
}
