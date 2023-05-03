package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.UserPrinciple;
import com.example.besocialnetwork.model.Users;
import com.example.besocialnetwork.repository.IUserRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService implements ICRUDService<Users, Long>, UserDetailsService {

    private final IUserRepository userRepository;


    @Autowired
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

}
