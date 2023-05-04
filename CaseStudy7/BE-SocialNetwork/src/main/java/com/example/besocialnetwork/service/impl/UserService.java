package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.DTO.UsersDTO;
import com.example.besocialnetwork.model.UserPrinciple;
import com.example.besocialnetwork.model.Users;
import com.example.besocialnetwork.repository.IUserRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class UserService implements ICRUDService<Users, Long>, UserDetailsService {
    private final IUserRepository userRepository;
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Iterable<Users> findAll() {
        return this.userRepository.findAll();
    }
    @Override
    public Optional<Users> findById(Long aLong) {
        return this.userRepository.findById(aLong);
    }
    @Override
    public Users save(Users user) {
        return this.userRepository.save(user);
    }
    @Override
    public void deleteById(Long aLong) {
       this.userRepository.deleteById(aLong);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = this.userRepository.findUsersByUsername(username);
        if (!usersOptional.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(usersOptional.get());
    }
    public Optional<Users> findByUsername(String name){
        return this.userRepository.findUsersByUsername(name);
    }
    public Iterable<String> findAllEmail(){
        return this.userRepository.findAllEmail();
    }
    public Iterable<String> findAllUsername(){
        return this.userRepository.findAllUsername();
    }
    public Iterable<String> findAllPhone(){
        return this.userRepository.findAllPhone();
    }
    public Optional<Users> findByUsernameOrEmail(String username, String email){
        return this.userRepository.findUsersByUsernameOrEmail(username, email);
    }
    public List<UsersDTO> findAllFriend(Long id){
        List<Users> usersList = this.userRepository.findAllFriend(id);
        return usersList.stream().map(user -> new UsersDTO(user.getId(), user.getName(), user.getUsername(), user.getAvatar(), user.isStatus())).collect(Collectors.toList());

    }
    public Integer countFriend(Long id){
        return this.userRepository.countFriend(id);
    }



}
