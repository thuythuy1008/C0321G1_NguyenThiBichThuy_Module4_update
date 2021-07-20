package com.codegym.controller;

import com.codegym.model.service.ConvertCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrencyController {
    @Autowired
    ConvertCurrencyService convertCurrencyService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/calculate")
    public String result(@RequestParam String usdInput, Model model) {
        double vnd = convertCurrencyService.convert(usdInput);
        model.addAttribute("usdInput", usdInput);
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
