package com.zugno.scheduler;

import com.zugno.scheduler.executor.DefaultScriptExecutor;
import com.zugno.scheduler.executor.ScriptExecutor;
import com.zugno.scheduler.schedule.DefaultScheduler;
import com.zugno.scheduler.schedule.Scheduler;
import com.zugno.scheduler.script.BatchScript;
import com.zugno.scheduler.script.CleanupScript;
import com.zugno.scheduler.script.Script;
import com.zugno.scheduler.script.SystemAutomationScript;
import java.lang.Comparable;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Criação de alguns scripts
        Script batchScript = new BatchScript("C:/Users/skyla/Desktop/batchtest/rune.bate");
//        Script cleanupScript = new CleanupScript("path/to/cleanup/directory");
//        Script systemAutomationScript = new SystemAutomationScript("ping www.google.com");

        // Criação de um executor
        ScriptExecutor scriptExecutor = new DefaultScriptExecutor();

        // Criação de um agendador
        Scheduler scheduler = new DefaultScheduler();

        // Agendamento de scripts
        scheduler.schedule(batchScript);
//        scheduler.schedule(cleanupScript);
//        scheduler.schedule(systemAutomationScript);

        // Execução do próximo script agendado
        scheduler.executeNext();

        // Agendamento e execução de um novo script
        Script customScript = new Script() {
            @Override
            public void execute() {
                System.out.println("Executando um script personalizado.");
            }
        };

        scheduler.schedule(customScript);
        scheduler.executeNext();
    }
}