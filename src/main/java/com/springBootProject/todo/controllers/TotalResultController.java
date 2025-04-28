package com.springBootProject.todo.controllers;

import com.springBootProject.todo.beans.TaskByDate;
import com.springBootProject.todo.beans.TotalResult;
import com.springBootProject.todo.services.TotalResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class TotalResultController {
    @Autowired
    TotalResultService totalResultService;

    @GetMapping("taskoverview/{userId}")
    public TotalResult totalReview(@PathVariable String userId){
        return totalResultService.totalReview(userId);
    }

    @GetMapping("taskoverviewbydate")
    public TotalResult totalReviewByDate(@RequestBody TaskByDate taskByDate){
        return totalResultService.totalReviewByDate(taskByDate);
    }
}
