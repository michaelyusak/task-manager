package com.idana.task_manager.task;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
		return taskRepository.findAll();
	}

    public void postTask(String activity) {
        taskRepository.save(new Task (
            activity,
            2L,
            LocalDate.now(),
            LocalDate.now()
        ));
    }

    public List<Task> getTasksByStatus(Long statusId) {
        return taskRepository.getTasksByStatus(statusId);
    }

    public void updateTask(Task task) {
        if (taskRepository.existsById(task.getId())) {
            taskRepository.updateTask(task.getActivity(), task.getStatusId());
        } else {
            throw new IllegalStateException("task not found");
        }
    }

}
