package com.example.fashoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashoin.model.SignUp;
import com.example.fashoin.repository.SignRepo;

@Service
public class SignService 
{
    @Autowired
    private SignRepo signRepo;

    public SignUp signup(SignUp signup) 
    {
        return signRepo.save(signup);
    }
    public SignUp getUser(String email) {
        return signRepo.findByEmailId(email);
    }

    public SignUp loginCheck(String email, String password) {
        return signRepo.findByEmailIdAndPassword(email, password);
    }
}
