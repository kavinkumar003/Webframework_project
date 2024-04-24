package com.example.fashoin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashoin.model.Fashion;
import com.example.fashoin.service.FashionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;








@RestController
public class FashionController 
{
    @Autowired
    public FashionService fashionService;
    
    @PostMapping("/dress")
    public String savedetails(@RequestBody Fashion fashion)
    {
        fashionService.saveFashion(fashion);
        return "New dress colletion are added";
    }
    @GetMapping("/dress")
    public List<Fashion> getfulldetails()
    {
         return fashionService.getAll();
    }
    @GetMapping("/dresss/{dresscode}")
    public Fashion getfetchdata(@PathVariable int dresscode) 
    {
        return fashionService.getFashion(dresscode);
    }
    @PutMapping("/dress/update/{dresscode}")
    public String putMethodName(@PathVariable int dresscode, @RequestBody Fashion updateFashion) 
    {
        Fashion existdress = fashionService.getFashion(dresscode);  
       if(existdress !=null)
       {
             existdress.setTypeofdress(updateFashion.getTypeofdress());
             existdress.setSize(updateFashion.getSize());
             existdress.setTypesoffabric(updateFashion.getTypesoffabric());
             existdress.setCount(updateFashion.getCount());
             fashionService.saveFashion(existdress);
       }
       else
       {
             return "The dress is out of stock";
       }
       return "New dress is updated in the database";

    }
    @DeleteMapping("/dress/delete/{dresscode}")
    public ResponseEntity<String> deletedress(@PathVariable int dresscode)
    {
        Fashion existdress=fashionService.getFashion(dresscode);
        if(existdress!=null)
        {
            fashionService.deletedress(dresscode);
            return new ResponseEntity<>("The dress details are deleted successfully",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Data not existed",HttpStatus.BAD_REQUEST);
       
        
    }
    @GetMapping("path/{page}/{size}")
    public List<Fashion> Getpage(@PathVariable int page,@PathVariable int size)
    {
         return fashionService.displayPage(page, size).getContent();
    }
    @GetMapping("sizeof/{size}")
   
    
    public List<Fashion> showsize(@PathVariable String size)
    {
        return fashionService.findthesize(size);
    }
   
   

}
    
   
    
   
   
