package com.zugno.scheduler.executor;

import com.zugno.scheduler.script.Script;

public class DefaultScriptExecutor implements ScriptExecutor {

    @Override
    public void executeScript(Script script) {
        System.out.println("Executando script usando DefaultScriptExecutor: " + script.getClass().getSimpleName());
        script.execute();
    }
}
