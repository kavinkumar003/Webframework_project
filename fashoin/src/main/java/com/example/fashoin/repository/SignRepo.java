package com.example.fashoin.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fashoin.model.SignUp;


@Repository
public interface SignRepo extends JpaRepository<SignUp, String> {

    SignUp findByEmailId(String emailId);

    SignUp findByEmailIdAndPassword(String emailId, String password);

}