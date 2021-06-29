package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    File logFile = new File("log.txt");

    public LogWriter(String message){

        boolean append = logFile.exists() ? true : false;
        try (
                PrintWriter writer =
                        new PrintWriter(new FileOutputStream(logFile, append))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a ");
            LocalDateTime date = LocalDateTime.now();
            String dateText = date.format(formatter);
			writer.append(dateText).append(message);
            writer.println();
        } catch(
                IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
