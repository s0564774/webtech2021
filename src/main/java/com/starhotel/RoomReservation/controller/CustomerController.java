package com.starhotel.RoomReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.starhotel.RoomReservation.domain.Customer;
import com.starhotel.RoomReservation.service.CustomerService;


// Problem mit der @Controller vs @RestController !!!!
@Controller
public class CustomerController {

	@Autowired
    private CustomerService service;
	
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Customer> listcustomer = service.listAll();
        model.addAttribute("listcustomer", listcustomer);
        System.out.print("Get / ");	
        return "index2";
    }
   
    
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "new";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer cust) {
        service.save(cust);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("new");
        Customer cust = service.get(id);
        mav.addObject("customer", cust);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletecustomer(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/";
    }
    
    
    
}
