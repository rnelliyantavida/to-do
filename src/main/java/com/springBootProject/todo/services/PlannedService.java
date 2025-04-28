package com.springBootProject.todo.services;

import com.springBootProject.todo.beans.Planned;
import com.springBootProject.todo.repositories.PlannedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlannedService {
    @Autowired
    PlannedRepository plannedRepository;

    public void plannedTask(Planned planned) {
        planned.setDate(LocalDate.now());
        plannedRepository.save(planned);
    }

    public List<String> tasks(String userId) {
        List<String> tasks = new ArrayList<>();
        for(Planned planned: plannedRepository.findAll()){
            if(planned.getUserId().equals(userId)){
                tasks.add(planned.getTaskPlanned());
            }
        }
        return tasks;
    }
}
