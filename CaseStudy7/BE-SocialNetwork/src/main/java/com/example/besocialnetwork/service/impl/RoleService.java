package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.Role;
import com.example.besocialnetwork.repository.IRoleRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class RoleService implements ICRUDService<Role, Long> {
    private final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(String name){
        return this.roleRepository.findByName(name);

    }
    @Override
    public Iterable<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
