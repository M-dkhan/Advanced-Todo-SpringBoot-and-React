package com.example.Todo.models;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean completed;

    public Task() {
        // Default constructor
    }

    public Task(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTask(){
        return this.task;
    }

    public boolean getCompleted(){
        return this.completed;
    }

    public void setTask(String task){
        this.task = task;
    }
    
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
