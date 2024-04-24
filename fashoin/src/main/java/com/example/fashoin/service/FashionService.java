package com.example.fashoin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.fashoin.model.Fashion;
import com.example.fashoin.repository.FashionRepositery;




@Service
public class FashionService 
{
    @Autowired
    public FashionRepositery fashionRepositery;

    public Fashion saveFashion(Fashion fashion)
    {
         return fashionRepositery.save(fashion);
    }
    public List<Fashion> getAll()
    {
        return fashionRepositery.findAll();
    }
    public Fashion getFashion(int dresscode)
    {
        return fashionRepositery.findById(dresscode).orElse(null);
    }
    public void deletedress(int dresscode)
    {
        fashionRepositery.deleteById(dresscode);
    }
    public Page<Fashion> displayPage(int pno,int size)
    {
        PageRequest pageRequest = PageRequest.of(pno,size,Sort.by(Direction.DESC,"dresscode"));
        return fashionRepositery.findAll(pageRequest);
    }
    public List<Fashion> findthesize(String a)
    {
        return fashionRepositery.findBySize(a);
    }

}
