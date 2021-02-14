package com.evil.inc.taskrssokeycloak.web;

import com.evil.inc.taskrssokeycloak.domain.Priority;
import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ModelAndView tasks(Principal principal){
        ModelAndView modelAndView = new ModelAndView("tasks");
        modelAndView.addObject("userName", principal.getName());
        modelAndView.addObject("userTasks", taskService.getTasksByUsername(principal.getName()));
        modelAndView.addObject("priorities", Priority.values());
        modelAndView.addObject("task", new Task());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addTask(@ModelAttribute Task task, Principal principal){
        task.setUserName(principal.getName());
        taskService.addTask(task);
        return new ModelAndView("redirect:/tasks");
    }

    @PostMapping("/delete/{taskId}")
    public ModelAndView deleteTask(@PathVariable long taskId){
        taskService.deleteTaskById(taskId);
        return new ModelAndView("redirect:/tasks");
    }
}
