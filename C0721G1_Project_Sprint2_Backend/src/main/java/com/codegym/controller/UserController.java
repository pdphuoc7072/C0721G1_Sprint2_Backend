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

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/public/user")
@CrossOrigin
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO, BindingResult bindingResult) {
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
            user.setCode(getUserCode());
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

    private String getUserCode() {
        String code = "TK-";
        List<Integer> codeList = new ArrayList<>();
        List<User> userList = userService.findAll();
        for (User user : userList) {
            String[] arrayCode = user.getCode().split("-");
            codeList.add(Integer.parseInt(arrayCode[1]));
        }
        Collections.sort(codeList);
        int index = 0;
        for (int i = 0; i < codeList.size(); i++) {
            if (i == codeList.size() - 1) {
                index = codeList.size();
                break;
            }
            if (codeList.get(i + 1) - codeList.get(i) >= 2) {
                index = i + 1;
                break;
            }
        }
        if (index > 998) {
            return code += (index + 1);
        }
        if (index > 98) {
            return code += "0" + (index + 1);
        }
        if (index > 8)
        {
            return code += "00" + (index + 1);
        }
        if (index > 0) {
            return code += "000" + (index + 1);
        }
        return code;
    }

}
