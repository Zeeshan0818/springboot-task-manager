package com.zeeshan.taskmanager.Service;

import com.zeeshan.taskmanager.Dto.UserResponse;
import com.zeeshan.taskmanager.Entity.Userentity;
import com.zeeshan.taskmanager.Repository.Userrepository;
import com.zeeshan.taskmanager.Security.JWTUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    private final Userrepository userrepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public Userservice(Userrepository userrepository,BCryptPasswordEncoder passwordEncoder,JWTUtil jwtUtil) {
        this.userrepository = userrepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Userentity save(Userentity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userrepository.save(user);
    }

    public List<UserResponse> findAll() {
        return userrepository.findAll()
                .stream()
                .map(userentity -> new UserResponse(userentity.getId(), userentity.getUsername()))
                .toList();
    }

    public String login(String username,String password){

        Userentity user = userrepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(username);
    }
}
