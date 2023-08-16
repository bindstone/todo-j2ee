package com.bindstone.todo.task;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/tasks")
@RequestScoped
public class TaskResource {

    @Inject
    TaskService taskService;

    @APIResponse(description = "return a list of tasks")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
}