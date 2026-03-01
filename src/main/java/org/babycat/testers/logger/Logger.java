package org.babycat.testers.logger;

import jakarta.annotation.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Master logger platform system.
 * @author babycat_offical
 * @since 2026-03-02
 * @version 0.1.0
 */
public class Logger {
    // Master Dev (babycat_offical) thinks this, "Well, I make non-static, but it will be good?"
    // But we can use @Qualifier system to not collision to DebugLogger. :)
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final List<String> Data = new ArrayList<>();

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss+09:00");

    /**
     * Prints Info log to the console.
     * @param Message The message. You can put a method or function's Message.
     * @param SendFrom The method or function's name. You can put the null.
     */
    public void Info(
            String Message,
            @Nullable String SendFrom) {
        try {

            StringBuilder builder = new StringBuilder("[" +
                    (!Objects.equals(SendFrom, null) && !SendFrom.isBlank() ? SendFrom.toUpperCase() : ANSI_YELLOW + "UNK" + ANSI_RESET)
                    + "." + ANSI_GREEN +"LOG"+ ANSI_RESET + "+" + format.toFormat() + "] " + Message);

            Data.add(builder.toString());

            System.out.println(builder);
        } catch (Exception e) {
            System.err.print("Critical Error in Logger Platform.\n Details: " + e.getMessage());
        }
    }

    /**
     * Prints the Error log to the console.
     * @param ErrMessage  The error message. You can put a method or function's Error message.
     * @param SendFrom The method or function's name. You can put the null.
     * @param CauseBy The Cause message. You can put Exception.getCausedBy() or the null.
     * */
    public void Error(
            String ErrMessage,
            @Nullable String SendFrom,
            @Nullable String CauseBy) {
        try {

            StringBuilder builder = new StringBuilder("*\n| [" +
                    (!Objects.equals(SendFrom, null) && !SendFrom.isBlank() ? SendFrom.toUpperCase() : ANSI_YELLOW + "UNK" + ANSI_RESET)
                    + "." + ANSI_RED + "ERR" + ANSI_RESET + "+" + format.toFormat() + "] " + "We're Sorry. An error found in " +   ErrMessage + "\n| Caused By: " +
                    (!Objects.equals(CauseBy, null) ? CauseBy : "Unknown") + "\n*");

            Data.add(builder.toString());

            System.out.println(builder);
        } catch (Exception e) {
            System.err.print("Critical Error in Logger Platform.\n Details: " + e.getMessage());
        }
    }

    /**
     * Prints the Warning log to the console
     * @param Message The message. You can put a method or function's Warning message.
     * @param SendFrom The method or function's name. You can put the null.
     * */
    public void Warn(
            String Message,
            @Nullable String SendFrom) {
        try {

            boolean equal = !Objects.equals(SendFrom, null) && !SendFrom.isBlank();
            StringBuilder builder = new StringBuilder("[" +
                    (equal ? SendFrom.toUpperCase() : ANSI_YELLOW + "UNK" + ANSI_RESET)
                    + "." + ANSI_YELLOW + "WARN" + ANSI_RESET + "+" + format.toFormat() + "] " + "Program "+ SendFrom +
                    (equal ? SendFrom.toUpperCase() : ANSI_YELLOW + "Unknown" + ANSI_RESET)
                    + "Sends Warning. Message: " + Message);

            Data.add(builder.toString());

            System.out.println(builder);
        } catch (Exception e) {
            System.err.print("Critical Error in Logger Platform.\n Details: " + e.getMessage());
        }
    }


    /**
     * Writes all log messages. And clear all log data.
     * @since 2026-03-02
     * @author babycat_offical
     */
    protected void Write() {
        File file = new File("Log:" + DateTimeFormatter.ofPattern("yy:MM:dd:HH:mm:ss+09:00"));
        Path path = Paths.get("Logs");

       try(var writer = new FileWriter(file, true)){
            var builder = new StringBuilder();

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            for (String s : Data) {
                try {
                builder.append(s).append("\n");
                } catch (Exception e) {
                    System.err.println("Failure to create " + file + "error log: " + e.getMessage());
                    throw e;
                }
            }
           builder.append(ANSI_RESET);
           writer.write(builder.toString());
           builder.delete(0, builder.length());
           Data.clear();
       }
       catch(IOException e) {
           System.err.println("[LOG." + ANSI_RED + "ERR" + ANSI_RESET + "] Unable to write Log file. Details: " + e.getMessage());
       }
       finally {
            IO.println("[LOG." +ANSI_GREEN + "SUCCESS" + ANSI_RESET + "] Complete to create " + file + ".");
       }
    }
}
