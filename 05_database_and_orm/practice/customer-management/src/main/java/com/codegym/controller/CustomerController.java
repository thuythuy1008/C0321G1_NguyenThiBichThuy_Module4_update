package com.codegym.controller;

import com.codegym.model.bean.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping(value = "/customer")
@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = {"/", "/list"})
    public ModelAndView goListCustomer() {
        ModelAndView modelAndView = new ModelAndView("list_customer");
        List<Customer> customerList = iCustomerService.findAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping(value = "/detail")
    public String goDetailCustomer(@RequestParam Integer idCustomer, Model model) {
        model.addAttribute("customerObj",
                this.iCustomerService.findById(idCustomer));
        return "detail_customer";
    }

    @GetMapping(value = "/detail/{idCustomer}")
    public String goDetailStudentPV(@PathVariable Integer idCustomer, Model model) {
        model.addAttribute("customerObj",
                this.iCustomerService.findById(idCustomer));
        return "detail_customer";
    }

    @GetMapping(value = "/create")
    public String goCreateNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "create_customer";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg",
                "Create new successfully!");
        return "redirect:/customer/list";
    }
}
