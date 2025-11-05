package br.com.dev.osorio.felipe.TO_DO.entity;

import br.com.dev.osorio.felipe.TO_DO.util.StatusTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

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
    private LocalDate endTime;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String name, String description, LocalDate endTime, StatusTask status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.endTime = endTime;
        this.status = status;
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

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }
}
