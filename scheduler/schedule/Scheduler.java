package com.zugno.scheduler.schedule;

import com.zugno.scheduler.script.Script;

public interface Scheduler {

    /**
     * Agenda um script para execução.
     *
     * @param script O script a ser agendado.
     */
    void schedule(Script script);

    /**
     * Executa o próximo script agendado, se houver algum.
     */
    void executeNext();
}
