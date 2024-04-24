package com.example.fashoin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashoin.model.Customer;
import com.example.fashoin.service.CustomerService;

@RestController
public class CustomerController 
{
    @Autowired
    public CustomerService customerService;

    @PostMapping("/details")
    public String savedetails(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
        return "Customer data is added";
    }
    @GetMapping("/details")
    public List<Customer> getfulldetails()
    {
         return customerService.getAll();
    }
    @GetMapping("/customer/{id}")
    public Customer getfetchdata(@PathVariable int id) 
    {
        return customerService.getCustomer(id);
    }
    @DeleteMapping("/customer/delete/{id}")
    public String deletedress(@PathVariable int id)
    {
        Customer existcutomer=customerService.getCustomer(id);
        if(existcutomer!=null)
        {
            customerService.deletecustomer(id);
        }
        return "The customer details are deleted successfully";
        
    }
    @PutMapping("/customer/update/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Customer updatecustomer) 
    {
        Customer existcustomer = customerService.getCustomer(id);  
       if(existcustomer !=null)
       {
             existcustomer.setName(updatecustomer.getName());
             existcustomer.setAddress(updatecustomer.getAddress());
             existcustomer.setMobileno(updatecustomer.getMobileno());
             customerService.saveCustomer(existcustomer);
       }
       else
       {
             return "Customer id not found";
       }
       return "Customer details is updated";

    }
}
