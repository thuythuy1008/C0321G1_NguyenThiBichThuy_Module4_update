package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.PositionEmpl;
import com.codegym.model.service.employee.EmployeeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("divisionList")
    public List<Division> showDivisionList() {
        return employeeService.findAllByDivision();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> showEducationDegreeList() {
        return employeeService.findAllByEducationDegree();
    }

    @ModelAttribute("positionEmplList")
    public List<PositionEmpl> showPositionEmplList() {
        return employeeService.findAllByPositionEmpl();
    }

    @GetMapping(value = {"/employee", "/employee/search"})
    public ModelAndView listEmployee(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam Optional<String> name) {
        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        Page<Employee> employees = employeeService.findByEmployeeName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

//    @PostMapping("/delete-customer")
//    public String showDeleteForm(@RequestParam Integer id) {
//        customerService.delete(id);
//        return "redirect:/customer";
//    }
//
//    @GetMapping("/create-customer")
//    public String showCreateForm(Model model) {
//        model.addAttribute("customerDto", new CustomerDto());
//        return "/customer/create";
//    }
//
//    @PostMapping({"/create-customer"})
//    public String checkValidation(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
//                                  BindingResult bindingResult) {
//        if (bindingResult.hasFieldErrors()) {
//            return "/customer/create";
//        } else {
//            Customer customer = new Customer();
//            BeanUtils.copyProperties(customerDto, customer);
//            customerService.save(customer);
//            return "redirect:/customer";
//        }
//    }
//
//    @GetMapping("/edit-customer/{id}")
//    public String showEditForm(@PathVariable Integer id, Model model) {
//        Customer customer = customerService.findById(id);
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customer, customerDto);
//        model.addAttribute("customerDto", customerDto);
//        return "/customer/edit";
//    }
//
//    @PostMapping({"/edit-customer"})
//    public String updateBlog(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasFieldErrors()) {
//            return "/customer/edit";
//        } else {
//            Customer customer = new Customer();
//            BeanUtils.copyProperties(customerDto, customer);
//            customerService.save(customer);
//            redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
//            return "redirect:/customer";
//        }
//    }
}
