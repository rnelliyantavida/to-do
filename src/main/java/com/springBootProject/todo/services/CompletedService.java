package com.springBootProject.todo.services;

import com.springBootProject.todo.beans.Completed;
import com.springBootProject.todo.beans.Planned;
import com.springBootProject.todo.repositories.CompletedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompletedService {
    @Autowired
    CompletedRepository completedRepository;

    public void completedTask(Completed completed) {
        completed.setDate(LocalDate.now());
        completedRepository.save(completed);
    }

    public List<String> tasksComplete(String userId) {
        List<String> tasks = new ArrayList<>();
        for(Completed completed: completedRepository.findAll()){
            if(completed.getUserId().equals(userId)){
                tasks.add(completed.getTaskCompleted());
            }
        }
        return tasks;
    }
}
