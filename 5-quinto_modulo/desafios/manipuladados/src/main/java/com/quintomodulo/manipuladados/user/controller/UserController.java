package com.quintomodulo.manipuladados.user.controller;

import com.quintomodulo.manipuladados.user.model.User;
import com.quintomodulo.manipuladados.user.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping
    public Iterable<User> findAll(){
        return this.userServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userServiceInterface.findById(id).get();
    }

    @GetMapping("/ByAccelerationName/{name}")
    public List<User> findByAccelerationName(@PathVariable("name") String name){
        return this.userServiceInterface.findByAccelerationName(name);
    }

    @GetMapping("/ByCompanyId/{id}")
    public List<User> findByCompanyId(@PathVariable("id") Long id){
        return this.userServiceInterface.findByCompanyId(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return this.userServiceInterface.save(user);
    }

}
