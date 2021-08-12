package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.service.customer.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> showCustomerTypeList() {
        return customerService.findAllByCustomerType();
    }

    @GetMapping(value = {"/customer", "/customer/search"})
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam Optional<String> keyWord) {
        String nameValue = "";
        if (keyWord.isPresent()) {
            nameValue = keyWord.get();
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Page<Customer> customers = customerService.findByCustomerName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @PostMapping("/delete-customer")
    public String showDeleteForm(@RequestParam Optional<Integer> id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id.get());
        customer.setFlag(1);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!!!");
        return "redirect:/customer";
    }

    @GetMapping("/create-customer")
    public String showCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping({"/create-customer"})
    public String checkValidation(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Customer created successfully!!!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "/customer/edit";
    }

    @PostMapping({"/edit-customer"})
    public String updateCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Customer updated successfully!!!");
            return "redirect:/customer";
        }
    }
}
