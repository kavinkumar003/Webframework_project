package com.example.fashoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashoin.model.Customer;
import com.example.fashoin.repository.CustomerRepo;

@Service
public class CustomerService 
{
    @Autowired
    public CustomerRepo customerRepo;

    public Customer saveCustomer(Customer customer)
    {
         return customerRepo.save(customer);
    }
    public List<Customer> getAll()
    {
        return customerRepo.findAll();
    }
    public Customer getCustomer(int id)
    {
        return customerRepo.findById(id).orElse(null);
    }
    public void deletecustomer(int id)
    {
        customerRepo.deleteById(id);;
    }
}
