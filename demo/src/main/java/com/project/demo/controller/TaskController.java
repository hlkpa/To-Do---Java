package com.project.demo.controller;

import com.project.demo.models.DateGroup;
import com.project.demo.models.Task;
import com.project.demo.service.TaskServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public String getTasks(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<Task> tasks = taskService.getTasksByUsername(username);
        List<DateGroup> dateGroups = taskService.groupTasksByDate(tasks);
        
        dateGroups.sort(Comparator.comparing(DateGroup::getDate));
        model.addAttribute("tasks", dateGroups);


        return "index"; // Return the Thymeleaf template
    }

    @PostMapping("/add")
    public String addTask(@RequestParam("taskName") String taskName, @RequestParam("taskDate") String taskDate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        LocalDate date = LocalDate.parse(taskDate);

        // Add the task
        taskService.addTask(username, taskName, date);
        
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateTaskStatus(@RequestParam("taskId") Long taskId, @RequestParam("completed") Boolean done) {
        taskService.updateTaskStatus(taskId, done);
        
        return "redirect:/";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteTask(@RequestParam("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return "Task deleted successfully";
    }
}
