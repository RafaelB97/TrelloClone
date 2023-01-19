package com.rafaelbp.TrelloClone.controllers;

import com.rafaelbp.TrelloClone.dto.TaskRequest;
import com.rafaelbp.TrelloClone.models.Task;
import com.rafaelbp.TrelloClone.services.ITaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/list/{listId}/task")
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask(
            @PathVariable Long listId
    ) {
        return taskService.getAllTasksForList(listId);
    }

    @GetMapping("/{taskId}")
    public Task getTask(
        @PathVariable Long taskId,
        @PathVariable Long listId
    ) {
        var task = this.taskService.getTask(listId, taskId);
        return task;
    }

    @PostMapping
    public Task addTask(
            @PathVariable Long listId,
            @RequestBody TaskRequest taskRequest
    ) {
        Task addedTask = taskService.addTask(listId, taskRequest);
        return addedTask;
    }

    @PutMapping("/{taskId}")
    public Task updateTask(
            @PathVariable Long taskId,
            @PathVariable Long listId,
            @RequestBody Task task
    ) {
        Task updatedTask = taskService.updateTask(listId, taskId, task);
        return updatedTask;
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(
            @PathVariable Long taskId,
            @PathVariable Long listId
    ) {
        taskService.deleteTask(listId, taskId);
    }
}