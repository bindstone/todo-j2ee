package com.bindstone.todo.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    public Task getTask(int id) {
        return taskRepository.getTask(id);
    }

    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.updateTask(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }
}