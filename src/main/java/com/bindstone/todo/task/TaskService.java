package com.bindstone.todo.task;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TaskService {

    public List<Task> getTasks() {
        return List.of(
                new Task(1, "Learn Rust"),
                new Task(2, "Apply Rust"),
                new Task(3, "Master Rust")
        );
    }
}