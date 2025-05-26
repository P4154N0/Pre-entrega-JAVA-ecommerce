package com.hpglab.menus;

import java.io.IOException;

public class Cleanconsoleosdetected {
    public static void cleanConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }
            Process process = processBuilder.inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}