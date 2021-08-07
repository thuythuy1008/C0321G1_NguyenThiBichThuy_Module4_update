package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
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
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> showServiceTypeList() {
        return serviceService.findAllByServiceType();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> showRentTypeList() {
        return serviceService.findAllByRentType();
    }

    @GetMapping("/service")
    public String showServiceHome() {
        return "/service/service-home";
    }

    @GetMapping(value = {"/list", "/list/search"})
    public ModelAndView listService(@PageableDefault(value = 3) Pageable pageable,
                                  @RequestParam Optional<String> name) {
        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        ModelAndView modelAndView = new ModelAndView("/service/list");
        Page<Service> services = serviceService.findByServiceName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping("/create-service-villa")
    public String showCreateVilla(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create-villa";
    }

    @PostMapping({"/create-service-villa"})
    public String checkValidationVilla(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto,
                                  BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/service/create-villa";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/list";
        }
    }

    @GetMapping("/create-service-house")
    public String showCreateHouse(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create-house";
    }

    @PostMapping({"/create-service-house"})
    public String checkValidationHouse(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto,
                                  BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/service/create-house";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/list";
        }
    }

    @GetMapping("/create-service-room")
    public String showCreateRoom(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create-room";
    }

    @PostMapping({"/create-service-room"})
    public String checkValidationRoom(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto,
                                       BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/service/create-room";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/list";
        }
    }

    @PostMapping("/delete-service")
    public String showDeleteForm(@RequestParam Optional<Integer> id) {
        Service service = serviceService.findById(id.get());
        service.setFlag(1);
        serviceService.save(service);
        return "redirect:/list";
    }


//    @GetMapping("/edit-service-villa/{id}")
//    public String showEditForm(@PathVariable Integer id, Model model) {
//        Service service = serviceService.findById(id);
//        ServiceDto serviceDto = new ServiceDto();
//        BeanUtils.copyProperties(service, serviceDto);
//        model.addAttribute("serviceDto", serviceDto);
//        return "/service/create-villa";
//    }

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
}
