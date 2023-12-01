package com.zugno.scheduler.script;


import java.io.IOException;

public class BatchScript implements Script {

    private String batchFilePath;

    public BatchScript(String batchFilePath) {
        this.batchFilePath = batchFilePath;
    }

    public void setBatchFilePath(String batchFilePath) {
        this.batchFilePath = batchFilePath;
    }

    public String getBatchFilePath() {
        return batchFilePath;
    }

    @Override
    public void execute() {
        try {
            // Executa o script .bat
            Process process = Runtime.getRuntime().exec("cmd /c start " + batchFilePath);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            // Lida com exceções de execução do script
            e.printStackTrace();
        }
    }
}

