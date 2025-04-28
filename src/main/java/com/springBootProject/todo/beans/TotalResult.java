package com.springBootProject.todo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalResult {
    List<String> plannedTask;
    List<String> completedTask;
    double percentage;
}
