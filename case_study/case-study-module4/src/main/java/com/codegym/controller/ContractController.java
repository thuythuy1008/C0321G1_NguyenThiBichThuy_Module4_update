package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import com.codegym.model.service.contract.ContractService;
import com.codegym.model.service.employee.EmployeeService;
import com.codegym.model.service.service.ServiceService;
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
public class ContractController {
    @Autowired
    private ContractService contractService;

    @ModelAttribute("employeeList")
    public List<Employee> showEmployeeList() {
        return contractService.findAllByEmployee();
    }

    @ModelAttribute("customerList")
    public List<Customer> showCustomerList() {
        return contractService.findAllByCustomer();
    }

    @ModelAttribute("serviceList")
    public List<Service> showServiceList() {
        return contractService.findAllByService();
    }

    @GetMapping(value = {"/contract", "/contract/search"})
    public ModelAndView listContract(@PageableDefault(value = 3) Pageable pageable) {
        contractService.totalMoney();
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        Page<Contract> contracts = contractService.findByContractId(pageable);
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @PostMapping("/delete-contract")
    public String showDeleteForm(@RequestParam Optional<Integer> id, RedirectAttributes redirectAttributes) {
        Contract contract = contractService.findById(id.get());
        contract.setFlag(1);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Contract deleted successfully!!!");
        return "redirect:/contract";
    }

    @GetMapping("/create-contract")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping({"/create-contract"})
    public String checkValidation(@Valid @ModelAttribute("contractDto") ContractDto contractDto,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Contract created successfully!!!");
            return "redirect:/contract";
        }
    }

    @GetMapping("/edit-contract/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Contract contract = contractService.findById(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract, contractDto);
        model.addAttribute("contractDto", contractDto);
        return "/contract/edit";
    }

    @PostMapping({"/edit-contract"})
    public String updateContract(@Valid @ModelAttribute("contractDto") ContractDto contractDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/contract/edit";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Contract updated successfully!!!");
            return "redirect:/contract";
        }
    }
}
