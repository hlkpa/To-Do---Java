package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.models.DateGroup;
import com.project.demo.models.Task;
import com.project.demo.models.UserApp;
import com.project.demo.repositories.TaskRepository;
import com.project.demo.repositories.UserRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userrepo;

    public List<Task> getTasksByUsername(String username) {
    	UserApp user = userrepo.findByUsername(username);
    	
        return taskRepository.findByUser(user);
    }

    public void addTask(String username, String taskName, LocalDate taskDate) {
        Task task = new Task();
        task.setCompleted(false);
        task.setCreationDate(LocalDate.now());
        task.setTaskDate(taskDate);
        task.setTask(taskName);
        UserApp user = userrepo.findByUsername(username);
        task.setUser(user);
        taskRepository.save(task);
    }

    public void updateTaskStatus(Long taskId, Boolean done) {
        Optional<Task> task = taskRepository.findById(taskId);
        task.ifPresent(t -> {
            t.setCompleted(done);
            taskRepository.save(t);
        });
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

   /* public Map<String, List<Task>> groupTasksByDate(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.groupingBy(task -> task.getTaskDate().toString()));
    }*/
    
    public List<DateGroup> groupTasksByDate(List<Task> tasks) {
        // Group tasks by their date (LocalDate) and convert them into DateGroup objects
        Map<String, List<Task>> groupedTasks = tasks.stream()
                .collect(Collectors.groupingBy(task -> task.getTaskDate().toString()));

        // Convert map to list of DateGroup objects
        List<DateGroup> dateGroups = new ArrayList<>();
        for (Map.Entry<String, List<Task>> entry : groupedTasks.entrySet()) {
            dateGroups.add(new DateGroup(entry.getKey(), entry.getValue()));
        }

        return dateGroups;
    }
}
