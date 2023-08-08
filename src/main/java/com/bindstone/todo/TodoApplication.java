package com.bindstone.todo;

import com.bindstone.todo.controller.TodoController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/todo")
public class TodoApplication extends Application {

    public TodoApplication() {
        this.singletons.add(new TodoController());
    }

    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();

    public Set<Class<?>> getClasses() {
        return this.empty;
    }
    public Set<Object> getSingletons() {
        return this.singletons;
    }
}