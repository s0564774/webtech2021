package com.starhotel.RoomReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.starhotel.RoomReservation.domain.Customer;
 
 
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
 
}