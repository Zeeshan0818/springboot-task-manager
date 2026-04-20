package com.zeeshan.taskmanager.Controller;

import com.zeeshan.taskmanager.Dto.UserResponse;
import com.zeeshan.taskmanager.Entity.Userentity;
import com.zeeshan.taskmanager.Repository.Userrepository;

import com.zeeshan.taskmanager.Service.Userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class Usercontroller {

    private final Userservice userservice;

    public Usercontroller(Userservice userservice) {
        this.userservice = userservice;
    }

    @GetMapping
    public String test(){
        return "Your api is working";
    }

    @PostMapping
    public Userentity createUser(@RequestBody Userentity user){
        return userservice.save(user);
    }

    @GetMapping("/allusers")
    public List<UserResponse> getAllUsers(){
        return userservice.findAll();
    }
}
