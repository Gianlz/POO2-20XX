package com.zugno.scheduler.executor;

import com.zugno.scheduler.script.Script;

public interface ScriptExecutor {

    /**
     * Executa um script.
     *
     * @param script O script a ser executado.
     */
    void executeScript(Script script);
}
