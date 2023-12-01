package com.zugno.scheduler.script;


import java.io.File;

public class CleanupScript implements Script {

    private String directoryPath;

    public CleanupScript(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void setCleanupPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getCleanupPath() {
        return directoryPath;
    }

    @Override
    public void execute() {
        System.out.println("Executing CleanupScript for the directory: " + directoryPath);

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }

            System.out.println("CleanupScript completed for the directory: " + directoryPath);
        } else {
            System.err.println("The specified directory does not exist or is not a valid directory.");
        }
    }
}
