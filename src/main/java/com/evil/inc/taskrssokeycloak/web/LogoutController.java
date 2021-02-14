package com.evil.inc.taskrssokeycloak.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
    @GetMapping
    public ModelAndView logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return new ModelAndView("redirect:/");
    }
}
