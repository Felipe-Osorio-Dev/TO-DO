package br.com.dev.osorio.felipe.TO_DO.util;

public enum StatusTask {
    INIT("Tarefa a ser Iniciada!!"),
    RUNNING("Tarefa em Andamento!!"),
    FINISHED("Tarefa Finalizada!!");

    private String description;

    StatusTask(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
