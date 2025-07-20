package com.project.demo.models;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "task")
    private String task;

    @Column(name = "task_date")
    private LocalDate taskDate;

    @Column(name = "is_completed")
    private boolean completed;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp user;

    @Column(name = "modify_date")
    private LocalDate modifyDate;

    // Default constructor
    public Task() {}

    // Constructor with parameters
    public Task(String task, LocalDate taskDate, boolean isCompleted, LocalDate creationDate, UserApp user) {
        this.task = task;
        this.taskDate = taskDate;
        this.completed = isCompleted;
        this.creationDate = creationDate;
        this.user = user;
    }
    

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean isCompleted) {
        this.completed = isCompleted;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, taskDate, completed, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return completed == task1.completed &&
                Objects.equals(id, task1.id) &&
                Objects.equals(task, task1.task) &&
                Objects.equals(taskDate, task1.taskDate) &&
                Objects.equals(user, task1.user);
    }
}
