package com.rafaelbp.TrelloClone.controllers;

import com.rafaelbp.TrelloClone.models.Task;
import com.rafaelbp.TrelloClone.services.ITaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getTask(
        @PathVariable Long id
    ) {
        var task = this.taskService.getTask(id);
        return task;
    }

    @PostMapping
    public Task addTask(
            @RequestBody Task task
    ) {
        Task addedTask = taskService.addTask(task);
        System.out.println(task);
        return addedTask;
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task task
    ) {
        System.out.println(task);
        Task updatedTask = taskService.updateTask(id, task);
        return updatedTask;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(
            @PathVariable Long id
    ) {
        taskService.deleteTask(id);
        System.out.println("Task was deleted");
    }
}