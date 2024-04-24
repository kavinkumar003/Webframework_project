package com.example.fashoin.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @Id
    private int id;
    private String name;
    private String address;
    private String mobileno;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Fashion fashion;

    @OneToMany(mappedBy ="customer1",cascade = CascadeType.ALL)
    private List<Fashion> fashion1;
   
    
  
   
}

    
