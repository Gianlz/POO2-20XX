package com.zugno.scheduler.schedule;

import com.zugno.scheduler.script.Script;

import java.util.LinkedList;
import java.util.Queue;

public class DefaultScheduler implements Scheduler {

    private final Queue<Script> scriptQueue;

    public DefaultScheduler() {
        this.scriptQueue = new LinkedList<>();
    }

    @Override
    public void schedule(Script script) {
        scriptQueue.offer(script);
        logScriptScheduled(script);
    }

    private void logScriptScheduled(Script script) {
        System.out.println("Script scheduled: " + script.getClass().getSimpleName());
    }

    @Override
    public void executeNext() {
        if (!scriptQueue.isEmpty()) {
            Script nextScript = scriptQueue.poll();
            String scriptName = nextScript.getClass().getSimpleName();
            System.out.println("Executing next script: " + scriptName);
            nextScript.execute();
        } else {
            System.out.println("No scheduled scripts for execution.");
        }
    }
}