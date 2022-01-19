package com.codegym.controller;

import com.codegym.dto.*;
import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {
    @Autowired
    private IUserService iUserService;


    //    list user
    @GetMapping("/admin/user")
    public ResponseEntity<Page<User>> findAllUser(@RequestParam String code,
                                                  @RequestParam String name,
                                                  @RequestParam String phone,
                                                  @RequestParam int page,
                                                  @RequestParam int size) throws ParseException {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "code");

        Page<User> userPage = iUserService.findAllUser(code, name, phone, pageable);
        if (userPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }





    private String getCode() {
        String code = "NV-";
        List<Integer> codeList = new ArrayList<>();
        List<User> userList = iUserService.findAll();
        if (userList.isEmpty()) {
            return ("NV-001");
        } else {
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
            if (index > 999) {
                code += (index + 1);
            } else if (index > 99) {
                code += "0" + (index + 1);
            } else if (index > 9) {
                code += "00" + (index + 1);
            } else if (index > 0) {
                code += "000" + (index + 1);
            }
            return (code);
        }
    }


    @GetMapping("/admin/user/code")
    public ResponseEntity<User> getUserCode() {
        User userM = new User();
        userM.setCode(getCode());
        return new ResponseEntity<>(userM, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @PatchMapping("/admin/user/update")
    public ResponseEntity<HttpStatus> updateUser(@Valid @RequestBody UserDTO userDto, BindingResult bindingResult) {
        List<User> users = iUserService.getAll();
        userDto.setUserList(users);
        userDto.validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            String name = userDto.getName().trim();
            userDto.setName(name);
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/admin/user/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            User user = iUserService.findById(id).get();
            UserDTO userDto = new UserDTO();
            BeanUtils.copyProperties(user, userDto);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}

