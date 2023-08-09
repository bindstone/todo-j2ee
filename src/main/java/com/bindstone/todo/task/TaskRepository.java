package com.bindstone.todo.task;

import com.bindstone.todo.config.SessionWrapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TaskRepository {

    @Inject
    private SessionWrapper sessionWrapper;

    public List<Task> getTasks() {
        return sessionWrapper.selectList("getTasks");
    }

    public Task getTask(int id) {
        Map<String, Object> map = Map.of(
                "id", id
        );
        return sessionWrapper.selectOne("getTask", map);
    }

    public Task createTask(Task task) {
        task.setId(getTaskKey());
        sessionWrapper.insertOne("insertTask", task);
        return task;
    }

    public Task updateTask(Task task) {
        sessionWrapper.updateOne("updateTask", task);
        return task;
    }

    public void deleteTask(int id) {
        sessionWrapper.deleteOne("deleteTask", id);
    }

    private int getTaskKey() {
        return sessionWrapper.selectOne("getTaskKey", Map.of());
    }
}