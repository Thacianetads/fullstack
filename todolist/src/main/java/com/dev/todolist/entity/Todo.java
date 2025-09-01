package com.dev.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String name;
    private String description;
    private boolean completed;
    private int priority;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }
    public boolean iscompleted() {
        return completed;
    }
    public void setcompleted(boolean completed) {
        this.completed = completed;
    }
    public int getpriority() {
        return priority;
    }
    public void setpriority(int priority) {
        this.priority = priority;
    }

    
}
