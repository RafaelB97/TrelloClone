package com.rafaelbp.TrelloClone.services;

import com.rafaelbp.TrelloClone.dto.TaskRequest;
import com.rafaelbp.TrelloClone.exceptions.ListNotFoundException;
import com.rafaelbp.TrelloClone.exceptions.TaskNotFoundException;
import com.rafaelbp.TrelloClone.models.Task;
import com.rafaelbp.TrelloClone.models.ListModel;
import com.rafaelbp.TrelloClone.repositories.TaskRepository;
import com.rafaelbp.TrelloClone.repositories.ListRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private final ListRepository listRepository;

    public TaskService(TaskRepository taskRepository, ListRepository listRepository) {
        this.taskRepository = taskRepository;
        this.listRepository = listRepository;
    }

    private ListModel getList(Long listId) {
        ListModel list = this.listRepository.findById(listId)
                .orElseThrow(() -> new ListNotFoundException("List not found"));
        return list;
    }

    @Override
    public List<Task> getAllTasksForList(Long listId) {
        ListModel list = getList(listId);
        var tasks = this.taskRepository.findByListModel(list);
        return tasks;
    }

    @Override
    public Task getTask(Long listId, Long taskId) {
        ListModel list = getList(listId);
        Task task = this.taskRepository.findByIdAndListModel(taskId, list)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return task;
    }

    @Override
    public Task addTask(Long listId, TaskRequest taskRequest) {
        ListModel list = getList(listId);

        Task task  = Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .finish(false)
                .date(taskRequest.getDate())
                .listModel(list)
                .build();

        Task newTask = taskRepository.save(task);
        return newTask;
    }

    @Override
    @Transactional
    public Task updateTask(Long listId, Long taskId, Task reqTask) {
        Task task = this.getTask(listId, taskId);
        String newTitle = reqTask.getTitle();
        String newDescription = reqTask.getDescription();
        Boolean newFinish = reqTask.getFinish();
        String newDate = reqTask.getDate();

        if (newTitle != null) task.setTitle(newTitle);
        if (newDescription != null) task.setDescription(newDescription);
        if (newFinish != null) task.setFinish(newFinish);
        if (newDate != null) task.setDate(newDate);
        return task;
    }

    @Override
    public void deleteTask(Long listId, Long taskId) {
        Task task = this.getTask(listId, taskId);
        this.taskRepository.deleteById(task.getId());
    }
}
