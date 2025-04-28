package com.springBootProject.todo.controllers;

import com.springBootProject.todo.beans.Planned;
import com.springBootProject.todo.services.PlannedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlannedController {
    @Autowired
    PlannedService plannedService;

    @PostMapping("plannedtask")
    public void plannedTask(@RequestBody Planned planned){
        plannedService.plannedTask(planned);
    }

    @GetMapping("tasksplanned/{userId}")
    public List<String> tasks(@PathVariable String userId){
        return plannedService.tasks(userId);
    }
}
