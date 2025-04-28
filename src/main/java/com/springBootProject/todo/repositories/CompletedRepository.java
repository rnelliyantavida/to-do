package com.springBootProject.todo.repositories;

import com.springBootProject.todo.beans.Completed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedRepository extends JpaRepository<Completed,Integer> {
}
