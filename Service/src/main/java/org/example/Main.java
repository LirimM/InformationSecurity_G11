package org.example;

public class Main {
    
public static void main(String[] args) {
        // Log an event
        logEvent("Application", "EventViewerLogger", "Sample log message", WinNT.EVENTLOG_INFORMATION_TYPE);
    }

    private static void logEvent(String logName, String sourceName, String message, int eventType) {
        WinNT.HANDLE hEventLog = Advapi32.INSTANCE.RegisterEventSource(null, logName);

        if (hEventLog != null) {
            // Log the event
            boolean success = Advapi32.INSTANCE.ReportEvent(
                    hEventLog,
                    eventType,
                    0,
                    0,
                    null,
                    1,
                    0,
                    new String[]{message},
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
