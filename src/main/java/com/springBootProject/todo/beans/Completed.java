package com.springBootProject.todo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Completed {

    @Id
    int id;
    String userId;
    String taskCompleted;
    LocalDate date;
}
