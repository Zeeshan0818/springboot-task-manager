package com.zeeshan.taskmanager.Controller;

import com.zeeshan.taskmanager.Dto.Loginrequest;
import com.zeeshan.taskmanager.Dto.Loginresponse;
import com.zeeshan.taskmanager.Dto.UserResponse;
import com.zeeshan.taskmanager.Entity.Userentity;
import com.zeeshan.taskmanager.Service.Userservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final Userservice userservice;

    public AuthController(Userservice userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/login")
    public Loginresponse login(@RequestBody Loginrequest request){
        String token = userservice.login(request.getUsername(), request.getPassword());
        return new Loginresponse(token);
    }
}
