package com.example.besocialnetwork.controller;

import com.example.besocialnetwork.model.Role;
import com.example.besocialnetwork.model.Users;
import com.example.besocialnetwork.security.jwt.JwtResponse;
import com.example.besocialnetwork.security.jwt.JwtService;
import com.example.besocialnetwork.service.impl.RoleService;
import com.example.besocialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AccountController(UserService userService, PasswordEncoder passwordEncoder, RoleService roleService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        Optional<Users> currentUserCheck = this.userService.findByUsernameOrEmail(user.getUsername(), user.getUsername());
        if(currentUserCheck.isPresent()){
            Users currentUser = currentUserCheck.get();
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(currentUser.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = this.jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            currentUser.setStatus(true);
            this.userService.save(currentUser);
            return ResponseEntity.ok(
                    new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getName(), userDetails.getAuthorities(), currentUser.getEmail(), currentUser.getPhone(), currentUser.getBirthday(), currentUser.isStatus(), currentUser.isActive(), currentUser.getGender(), currentUser.getShowFriend(), currentUser.getCommentPermission(), currentUser.getAvatar(), currentUser.getAddress(), currentUser.getHobby()));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}
//        Authentication authentication = this.authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = this.jwtService.generateTokenLogin(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        Users currentUser = this.userService.findByUsername(user.getUsername()).get();
//        currentUser.setStatus(true);
//        this.userService.save(currentUser);
//        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getName(), userDetails.getAuthorities(), currentUser.getEmail(), currentUser.getPhone(), currentUser.getBirthday(), currentUser.isStatus(), currentUser.isActive(), currentUser.getGender(), currentUser.getShowFriend(), currentUser.getCommentPermission(), currentUser.getAvatar(), currentUser.getAddress(), currentUser.getHobby()));


    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        Optional<Role> roleCheck = this.roleService.findByName("USER");
        if(roleCheck.isPresent()){
            Optional<Users> usersOptional = this.userService.findByUsername(user.getUsername());
            if (!usersOptional.isPresent()) {
                String encodedPassword = this.passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                Role role = roleCheck.get();
                user.setRoles(new HashSet<>());
                user.getRoles().add(role);
                return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
            }}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    private boolean checkExist(Iterable<String> checks, String check) {
        boolean flag = true;
        for (String c : checks){
            if (c.equals(check)){
                flag = false;
                break;
            }
        }
        return !flag;

    }
    @GetMapping("/check/email/{email}")
    public ResponseEntity<String> checkEmail(@PathVariable String email) {
        Iterable<String> emailExist = this.userService.findAllEmail();
        String emailPattern = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return new ResponseEntity<>("Email invalidate", HttpStatus.OK);
        } else {
            if (this.checkExist(emailExist, email)){
                return new ResponseEntity<>("Email already exists", HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
    }
    @GetMapping("/check/username/{username}")
    public ResponseEntity<String> checkUsername(@PathVariable String username) {
        Iterable<String> usernameExist = this.userService.findAllUsername();
        if (this.checkExist(usernameExist, username)){
            return new ResponseEntity<>("Username already exists",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @GetMapping("/check/phone/{phone}")
    public ResponseEntity<String> checkPhone(@PathVariable String phone){
        Iterable<String> phoneExist = this.userService.findAllPhone();
        String phonePattern = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()){
            return new ResponseEntity<>("Phone number invalidate", HttpStatus.OK);
        }else{
            if (this.checkExist(phoneExist, phone)){
                return new ResponseEntity<>("Phone already exists", HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
    }
    @PutMapping("/logout/{id}")
    public ResponseEntity<Users> logOut(@PathVariable Long id, @RequestBody Users user){
        Optional<Users> usersCheck = this.userService.findById(id);
        if (usersCheck.isPresent()){
            user.setStatus(false);
            this.userService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
