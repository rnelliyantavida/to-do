package com.springBootProject.todo.repositories;

import com.springBootProject.todo.beans.Planned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedRepository extends JpaRepository<Planned,Integer> {
}
