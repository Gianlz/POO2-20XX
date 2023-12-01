package com.zugno.scheduler.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemAutomationScript implements Script, Comparable<SystemAutomationScript> {
    private final String command;

    public SystemAutomationScript(String command) {
        this.command = command;
    }

    public void execute() {
        try {
            // Your script execution logic here
            System.out.println("Executing system automation script: " + command);
        } catch (Exception e) {
            System.err.println("An error occurred during script execution: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String executeCommand(String command) {
        try {
            // Create the process builder with the command
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            // Return the output if the command was successful
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "Command failed with exit code: " + exitCode;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "An error occurred while executing the command: " + e.getMessage();
        }
    }

    @Override
    public int compareTo(SystemAutomationScript other) {
        return Integer.compare(this.command.length(), other.command.length());
    }
}