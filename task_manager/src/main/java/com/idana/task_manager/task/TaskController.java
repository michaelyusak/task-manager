package com.idana.task_manager.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping
	public List<Task> getTasks() {
		return taskService.getTasks();
	}

    @PostMapping
    public void postTask(@RequestBody String activity) {
        taskService.postTask(activity);
    }

    @GetMapping(path = "{statusId}")
    public List<Task> getTasksByStatus(@PathVariable("statusId") Long statusId) {
        return taskService.getTasksByStatus(statusId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(@PathVariable("taskId") Long id, @RequestBody Task task) {
        task.setId(id);

        taskService.updateTask(task);
    }
}
