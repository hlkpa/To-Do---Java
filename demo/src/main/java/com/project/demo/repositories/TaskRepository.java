package com.project.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.models.Task;
import com.project.demo.models.UserApp;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(UserApp user);

}