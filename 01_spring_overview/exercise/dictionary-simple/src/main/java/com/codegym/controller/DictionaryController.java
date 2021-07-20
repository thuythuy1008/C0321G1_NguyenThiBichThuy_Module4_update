package com.codegym.controller;

import com.codegym.model.service.DictionaryService;
import com.codegym.model.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/dictionary")
    public String result(@RequestParam String english, Model model) {
        model.addAttribute("eng", english);
        model.addAttribute("viet", dictionaryService.find(english));
        return "index";
    }
}
