package com.starhotel.RoomReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.starhotel.RoomReservation.domain.Customer;
import com.starhotel.RoomReservation.service.CustomerService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
    private CustomerService service;
    
    @GetMapping("/list")
    public List<Customer> list() {
        return service.listAll();
    }
	
}