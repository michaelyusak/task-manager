package com.idana.task_manager.status;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Status {
    @Id
    @SequenceGenerator(
        name = "status_sequence",
        sequenceName = "status_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "status_sequence"
    )
    private Long id;
    private String statusName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Status() {
    }

    public Status(
        Long id,
        String statusName,
        LocalDate createdAt,
        LocalDate updatedAt
    ) {
        this.id = id;
        this.statusName = statusName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Status(
        String statusName,
        LocalDate createdAt,
        LocalDate updatedAt
    ) {
        this.statusName = statusName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
