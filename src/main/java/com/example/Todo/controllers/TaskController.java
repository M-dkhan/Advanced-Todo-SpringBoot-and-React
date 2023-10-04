package com.example.Todo.controllers;

import com.example.Todo.models.Task;
import com.example.Todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    

    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks(){
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }

    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> getAllInCompletedTasks(){
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTaskById(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        taskService.deleteTask(task);
        return ResponseEntity.ok(true);
    }
}
