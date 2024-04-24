package com.example.fashoin.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.fashoin.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{

    
} 
