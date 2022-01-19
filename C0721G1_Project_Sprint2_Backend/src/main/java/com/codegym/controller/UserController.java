package com.codegym.controller;

import com.codegym.dto.BonusPointDto;
import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@EnableWebMvc
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Autowired
    IUserService iUserService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        try {
            Optional<User> user = iUserService.findById(id);
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userDto, user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/user/change-password/{id}/{oldPassword}/{newPassword}")
    public ResponseEntity<?> changePassword(@PathVariable Long id,
                                            @PathVariable String oldPassword,
                                            @PathVariable String newPassWord) {
        if (oldPassword.equals(newPassWord)) {
            return ResponseEntity.ok(1);
        }
        Optional<User> userCurrent = iUserService.findById(id);
        if (userCurrent.isPresent()) {
//            if (passwordEncoder.matches(oldPassword, userCurrent.get().getPassword())) {
//                userCurrent.get().setPassword(passwordEncoder.encode(newPassWord));
                if(oldPassword.equals(newPassWord)) {
                    userCurrent.get().setPassword(newPassWord);
                }

            iUserService.updateUser(userCurrent.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(2);
        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PatchMapping("/user/update/{id}")
    public ResponseEntity<?> updateUserDetail(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            user.setId(userDto.getId());
            iUserService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/user/points")
    public ResponseEntity<List<BonusPointDto>> getBonusPonits() {
        List<BonusPointDto> bonusPointDtoList = iUserService.getAll();
        if (!bonusPointDtoList.isEmpty()) {
            return new ResponseEntity<>(bonusPointDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/user/points/fetch/{startDate}/{endDate}")
    public ResponseEntity<List<BonusPointDto>> getBonusPonitsByTime(@PathVariable String startDate,
                                                                    @PathVariable String endDate) {
        LocalDate ld = LocalDate.parse(startDate);
        LocalDate ld1 = LocalDate.parse(endDate);
        List<BonusPointDto> bonusPointDtoList = iUserService.getBonusPointsByTime(ld, ld1);
        if (!bonusPointDtoList.isEmpty()) {
            return new ResponseEntity<>(bonusPointDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
