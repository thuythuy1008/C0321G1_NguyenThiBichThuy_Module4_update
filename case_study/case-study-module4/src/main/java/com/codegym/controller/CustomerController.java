package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/customer", "/search"})
    public ModelAndView listBlogs(@PageableDefault(value = 3) Pageable pageable,
                                  @RequestParam Optional<String> name) {
        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Page<Customer> customers = customerService.findByCustomerName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
