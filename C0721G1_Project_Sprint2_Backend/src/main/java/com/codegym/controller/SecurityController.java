package com.codegym.controller;

import com.codegym.jwt.JwtUtility;
import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.payload.request.LoginRequest;
import com.codegym.payload.response.JwtResponse;
import com.codegym.service.IUserService;
import com.codegym.service.impl.RoleServiceImpl;
import com.codegym.service.impl.UserDetailsImpl;
import com.codegym.service.impl.UserServiceImpl;
import com.codegym.util.RandomPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/*
Creator: TanTN
 */
@RestController
@RequestMapping("api/public")
@CrossOrigin
public class SecurityController {
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private RoleServiceImpl roleServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserService iUserService;

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";
    private static final String ROLE_ERROR = "Không tìm thấy quyền này.";


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        if ("FACEBOOK".equals(loginRequest.getProvider()) || "GOOGLE".equals(loginRequest.getProvider())) {
            Optional<User> findUser = iUserService.findByEmail(loginRequest.getEmail());
            if (!findUser.isPresent()) {
                User user = new User();
                user.setEmail(loginRequest.getEmail());
                user.setImage(loginRequest.getPhotoUrl());
                user.setName(loginRequest.getName());
                List<Role> roleList = getListRole();
                user.setRoles(roleList);
                user.setUsername(loginRequest.getEmail());
                loginRequest.setUsername(loginRequest.getEmail());
                String password = RandomPassword.getRandomPassword();
                loginRequest.setPassword(password);
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String newPassword = bCryptPasswordEncoder.encode(password);
                user.setPassword(newPassword);
                iUserService.save(user);
            }
        }
        List<String> roles1 = new ArrayList<>();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Optional<User> user = userServiceImpl.findByUsername(loginRequest.getUsername());
        if (user.isPresent()) {
            Optional<User> userOptional = iUserService.findById(user.get().getId());
            if (userOptional.isPresent()) {
                if (roles.get(0).equals(ROLE_ADMIN)) {
                    roles1.add(ROLE_USER);
                    roles1.add(ROLE_ADMIN);
                    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles1, userOptional.get()));
                }
                return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles, userOptional.get()));
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    private List<Role> getListRole (){
       List<Role> roleList = roleServiceImpl.findByName("ROLE_USER");
        return roleList;
    }

}
