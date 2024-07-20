package com.idana.task_manager.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM task WHERE statusId = ?1 WHERE deletedAt IS NULL", nativeQuery = true)
    List<Task> getTasksByStatus(Long statusId);

    @Query(value = "UPDATE task SET activity = ?1, statusId = ?2, updatedAt = NOW()", nativeQuery = true)
    void updateTask(String activity, Long statusId);
}
