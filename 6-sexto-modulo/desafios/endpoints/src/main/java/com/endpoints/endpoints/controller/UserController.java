package com.endpoints.endpoints.controller;

import com.endpoints.endpoints.entity.User;
import com.endpoints.endpoints.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long idUser){
        return userServiceInterface.findById(idUser).get();
    }

    @GetMapping
    public List<User> findByAccelerationName(@RequestParam(name = "accelerationName", required = false) Optional<String> accelerationName,
                                             @RequestParam(name = "companyId", required = false) Optional<Long> companyId){
        return accelerationName.isPresent() ?
                this.userServiceInterface.findByAccelerationName(accelerationName.get()) : companyId.isPresent() ?
                this.userServiceInterface.findByCompanyId(companyId.get()) : Collections.EMPTY_LIST;
    }

}
