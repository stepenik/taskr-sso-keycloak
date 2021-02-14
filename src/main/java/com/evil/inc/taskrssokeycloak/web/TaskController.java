package com.evil.inc.taskrssokeycloak.web;

import com.evil.inc.taskrssokeycloak.domain.Priority;
import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.service.TaskService;
import com.evil.inc.taskrssokeycloak.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class TaskController {
    private final UserService userService;
    private final TaskService taskService;

    @GetMapping
    public ModelAndView tasks(){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("tasks");
//        modelAndView.addObject("userName", authentication.getName());
        modelAndView.addObject("userName", "thejohndoe");
        modelAndView.addObject("userTasks", taskService.getTasksByUsername("thejohndoe"));
        modelAndView.addObject("priorities", Priority.values());
        modelAndView.addObject("task", new Task());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addTask(@ModelAttribute Task task){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        task.setUser(userService.getByUsername("thejohndoe"));
        taskService.addTask(task);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/delete/{taskId}")
    public ModelAndView deleteTask(@PathVariable long taskId){
        taskService.deleteTaskById(taskId);
        return new ModelAndView("redirect:/");
    }
}
