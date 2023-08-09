package com.bindstone.todo.resource;

import com.bindstone.todo.domain.Todo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/todos")
public class TodoResource {

    @APIResponse(description = "return a list of todos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Todo[] getTodos() {

        return new Todo[] {
                new Todo(1, "Learn Rust"),
                new Todo(2, "Apply Rust"),
                new Todo(3, "Master Rust") };
    }
}