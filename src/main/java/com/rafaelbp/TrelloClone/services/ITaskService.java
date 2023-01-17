package com.rafaelbp.TrelloClone.services;

import com.rafaelbp.TrelloClone.models.Task;

import java.util.List;

public interface ITaskService {
    List<Task> getAllTask();
    Task getTask(Long id);
    Task addTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
