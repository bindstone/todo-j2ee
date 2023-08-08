package com.bindstone.todo.controller;

import javax.ws.rs.*;
@Path("api/todo")
public class TodoController {

    @GET
    @Path("")
    public String helloworld() {
        return "Hello World!";
    }

}