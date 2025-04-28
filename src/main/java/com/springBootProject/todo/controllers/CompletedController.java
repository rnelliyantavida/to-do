package com.springBootProject.todo.controllers;

import com.springBootProject.todo.beans.Completed;
import com.springBootProject.todo.beans.Planned;
import com.springBootProject.todo.services.CompletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompletedController {
    @Autowired
    CompletedService completedService;

    @PostMapping("completedtask")
    public void completedTask(@RequestBody Completed completed){
        completedService.completedTask(completed);
    }

    @GetMapping("completedtasks/{userId}")
    public List<String> tasksComplete(@PathVariable String userId){
        return completedService.tasksComplete(userId);
    }
}
