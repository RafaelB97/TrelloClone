package com.rafaelbp.TrelloClone.services;

import com.rafaelbp.TrelloClone.dto.TaskRequest;
import com.rafaelbp.TrelloClone.models.Task;

import java.util.List;

public interface ITaskService {
    List<Task> getAllTasksForList(Long listId);
    Task getTask(Long listId, Long taskId);
    Task addTask(Long listId, TaskRequest task);
    Task updateTask(Long listId, Long taskId, Task task);
    void deleteTask(Long listId, Long task);
}
