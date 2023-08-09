package com.bindstone.todo.task;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.ibatis.annotations.Update;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/tasks")
@RequestScoped
@Tag(name = "TASK", description = "Task Operations")
public class TaskResource {

    @Inject
    TaskService taskService;

    @APIResponse(description = "return a list of tasks")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @APIResponse(description = "return a single tasks")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTask(@PathParam("id") int id) {
        return taskService.getTask(id);
    }

    @APIResponse(description = "create new tasks")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task insertTask(Task task) {
        return taskService.createTask(task);
    }

    @APIResponse(description = "update tasks")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task updateTask(Task task) {
        return taskService.updateTask(task);
    }

    @APIResponse(description = "return a single tasks")
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTask(@PathParam("id") int id) {
        taskService.deleteTask(id);
        return Response.ok().build();
    }

}