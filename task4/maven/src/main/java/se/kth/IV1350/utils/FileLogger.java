package se.kth.IV1350.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private PrintWriter logger;
    /**
     * Initializes a new instance of the FileLogger class.
    */
    public FileLogger() {
        try {
            logger = new PrintWriter(new FileWriter("ErrorLog.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Logs a message with a timestamp.
     *
     * @param  message  the message to log
     * @return          void
     */
    public void log(String message) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.println("[" + timeStamp + "] " + message+"\n");
        logger.flush();
    }
    /**
     * Logs a message along with the stack trace of an exception to a file.
     *
     * @param  message    the message to be logged
     * @param  exception  the exception whose stack trace is to be logged
     */
    public void log(String message, Exception exception) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.println("[" + timeStamp + "] " + message+"\n");
        exception.printStackTrace(logger);
        logger.flush();
    }
}
