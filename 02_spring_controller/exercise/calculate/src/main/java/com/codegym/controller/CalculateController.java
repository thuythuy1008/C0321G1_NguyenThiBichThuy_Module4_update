package com.codegym.controller;

import com.codegym.model.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private CalculateService calculateService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam double numberFirst, @RequestParam double numberSecond, @RequestParam String operator, Model model) {
        model.addAttribute("save", calculateService.save(numberFirst, numberSecond, operator));
        return "index";
    }

}
