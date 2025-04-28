package com.springBootProject.todo.services;

import com.springBootProject.todo.beans.Completed;
import com.springBootProject.todo.beans.Planned;
import com.springBootProject.todo.beans.TaskByDate;
import com.springBootProject.todo.beans.TotalResult;
import com.springBootProject.todo.repositories.CompletedRepository;
import com.springBootProject.todo.repositories.PlannedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TotalResultService {
    @Autowired
    PlannedRepository plannedRepository;
    @Autowired
    CompletedRepository completedRepository;

    public TotalResult totalReview(String userId) {
        List<String> plannedTask = new ArrayList<>();
        List<String> completedTask = new ArrayList<>();
        for(Planned planned: plannedRepository.findAll()){
            if (planned.getUserId().equals(userId) && (planned.getDate().compareTo(LocalDate.now()) == 0)){
                plannedTask.add(planned.getTaskPlanned());
            }
        }
        for (Completed completed: completedRepository.findAll()){
            if(completed.getUserId().equals(userId) && (completed.getDate().compareTo(LocalDate.now()) == 0)){
                completedTask.add(completed.getTaskCompleted());
            }
        }
        double percentage =  ((double) completedTask.size()/(double) plannedTask.size())*100;
        //System.out.println(percentage);
        return new TotalResult(plannedTask,completedTask,percentage);
    }

    public TotalResult totalReviewByDate(TaskByDate taskByDate) {
        List<String> plannedTask = new ArrayList<>();
        List<String> completedTask = new ArrayList<>();
        for(Planned planned: plannedRepository.findAll()){
            if (planned.getUserId().equals(taskByDate.getUserId()) && (planned.getDate().compareTo(taskByDate.getDate()) == 0)){
                plannedTask.add(planned.getTaskPlanned());
            }
        }
        for (Completed completed: completedRepository.findAll()){
            if(completed.getUserId().equals(taskByDate.getUserId()) && (completed.getDate().compareTo(taskByDate.getDate()) == 0)){
                completedTask.add(completed.getTaskCompleted());
            }
        }
        double percentage =  ((double) completedTask.size()/(double) plannedTask.size())*100;
        //System.out.println(percentage);
        return new TotalResult(plannedTask,completedTask,percentage);
    }
}
