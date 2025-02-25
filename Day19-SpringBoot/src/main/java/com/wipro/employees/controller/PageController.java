package com.wipro.employees.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homePage() {
        return "index"; // Serves index.html from templates folder
    }

    @GetMapping("/welcome/page1")
    public String page1() {
        return "page1"; // Create a page1.html file in templates
    }

    @GetMapping("/welcome/page2")
    public String page2() {
        return "page2"; // Create a page2.html file in templates
    }
}
