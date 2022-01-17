package com.codegym.controller;

import com.codegym.dto.UserCreateDTO;
import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.IRoleService;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/public/user")
@CrossOrigin
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            BeanUtils.copyProperties(userCreateDTO, user);
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            if(userService.existsByUsername(user.getUsername())){
                return new ResponseEntity<>(1,HttpStatus.BAD_REQUEST);
            }
            userService.save(user);
            Role role = roleService.findByName("ROLE_USER");
            User user1 = userService.findByUsername(user.getUsername());
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            user1.setRoles(roles);
            userService.save(user1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
