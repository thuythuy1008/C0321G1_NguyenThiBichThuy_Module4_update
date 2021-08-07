package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.CustomerOtherDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.service.customer_user_service.CustomerUserServiceService;
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
public class CustomerUserServiceController {
    @Autowired
    private CustomerUserServiceService customerUserServiceService;

    @ModelAttribute("contractList")
    public List<Contract> showContractList() {
        return customerUserServiceService.findAllByContract();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> showContractDetailList() {
        return customerUserServiceService.findAllByContractDetail();
    }

    @ModelAttribute("attachServiceList")
    public List<AttachService> showAttachServiceList() {
        return customerUserServiceService.findAllByAttachService();
    }

    @GetMapping(value = {"/customer-user-service", "/customer-user-service/search"})
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam Optional<String> name) {
        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        ModelAndView modelAndView = new ModelAndView("/customer_user_service/list");
        Page<CustomerOtherDto> customers = customerUserServiceService.findByCustomerName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @PostMapping("/delete-customer-user-service")
    public String showDeleteForm(@RequestParam Integer id) {
        System.out.println(id);
        customerUserServiceService.delete(id);

        return "redirect:/customer-user-service";
    }

    @GetMapping("/edit-customer-user-service/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Customer customer = customerUserServiceService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "/customer_user_service/edit";
    }

    @PostMapping({"/edit-customer-user-service"})
    public String updateCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/customer_user_service/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerUserServiceService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Customer updated successfully!!!");
            return "redirect:/customer-user-service";
        }
    }
}
