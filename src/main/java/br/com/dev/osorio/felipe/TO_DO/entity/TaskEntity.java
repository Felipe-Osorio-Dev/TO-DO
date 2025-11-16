package br.com.dev.osorio.felipe.TO_DO.entity;

import br.com.dev.osorio.felipe.TO_DO.util.PriorityTask;
import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100)
    @NotBlank(message = "Nome Obrigatório !!")
    @Column(length = 100, nullable = false)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @Enumerated(EnumType.STRING)
    private PriorityTask priority;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String name, String description, StatusTask status, PriorityTask priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    public PriorityTask getPriority() {
        return priority;
    }

    public void setPriority(PriorityTask priority) {
        this.priority = priority;
    }
}
