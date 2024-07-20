package com.idana.task_manager.task;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
        name = "task_sequence",
        sequenceName = "task_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "task_sequence"
    )
    private Long id;
    private String activity;
    private Long statusId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Task() {
    }

    public Task(Long id,
                String activity,
                Long statusId,
                LocalDate createdAt,
                LocalDate updatedAt) {
        this.id = id;
        this.activity = activity;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task(String activity,
                Long statusId,
                LocalDate createdAt,
                LocalDate updatedAt) {
        this.activity = activity;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatus(Long statusId) {
        this.statusId = statusId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }
}
