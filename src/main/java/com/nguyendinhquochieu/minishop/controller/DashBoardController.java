package com.nguyendinhquochieu.minishop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/dashboard")
@EnableWebMvc
public class DashBoardController {
    @GetMapping
    public String Default(){
        return "dashboard";
    }
}
