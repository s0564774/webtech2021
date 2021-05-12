package com.starhotel.RoomReservation.service;
import com.starhotel.RoomReservation.domain.Customer;
import com.starhotel.RoomReservation.repository.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> listAll() {
		return repo.findAll();
	}
	
	public void save(Customer cust) {
		repo.save(cust);
	}
	
	public Customer get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

	

}
