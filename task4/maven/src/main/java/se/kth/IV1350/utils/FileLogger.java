package se.kth.IV1350.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private PrintWriter logger;

    public FileLogger() {
        try {
            logger = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.println("[" + timeStamp + "] " + message+"\n");
        logger.flush();
    }

    public void log(String message, Exception exception) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.println("[" + timeStamp + "] " + message);
        exception.printStackTrace(logger);
        logger.flush();
    }
}
