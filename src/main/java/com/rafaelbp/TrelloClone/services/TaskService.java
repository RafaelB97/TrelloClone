package com.rafaelbp.TrelloClone.services;

import com.rafaelbp.TrelloClone.exceptions.TaskNotFoundException;
import com.rafaelbp.TrelloClone.models.Task;
import com.rafaelbp.TrelloClone.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTask() {
        var tasks = this.taskRepository.findAll();
        return tasks;
    }

    @Override
    public Task getTask(Long id) {
        Task task = this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return task;
    }

    @Override
    public Task addTask(Task task) {
        task.setFinish(false);
        Task addedTask = taskRepository.save(task);
        return addedTask;
    }

    @Override
    @Transactional
    public Task updateTask(Long id, Task updatedTask) {
        Task task = this.getTask(id);
        if (updatedTask.getTitle() != null) task.setTitle(updatedTask.getTitle());
        if (updatedTask.getDescription() != null) task.setDescription(updatedTask.getDescription());
        if (updatedTask.getFinish() != null) task.setFinish(updatedTask.getFinish());
        if (updatedTask.getDate() != null) task.setDate(updatedTask.getDate());
        return task;
    }

    @Override
    public void deleteTask(Long id) {
        Task task = this.getTask(id);
        this.taskRepository.deleteById(task.getId());
    }
}
