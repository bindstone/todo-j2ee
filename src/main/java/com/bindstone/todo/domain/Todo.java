package com.bindstone.todo.domain;

import java.util.Objects;

public class Todo implements Comparable<Todo> {
    private String name;
    private int id;

    public Todo() {
    }

    public Todo(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Todo)) {
            return false;
        }
        final Todo other = (Todo) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Todo[id=" + id + ", name=" + name + "]";
    }

    @Override
    public int compareTo(final Todo o) {
        return Integer.compare(id, o.id);
    }
}