package com.codegym.controller;

import com.codegym.model.bean.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ElectronicMailboxController {
    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("index", "email", new Email());
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("email") Email email){
        return new ModelAndView("result");
    }

}
