package edu.corvinus.beadando2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController
{

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @PostMapping("/signup")
    public String userSignup()
    {
        return "signup";
    }

    @PostMapping("/login")
    public String userLogin()
    {
        return "login";
    }
}
