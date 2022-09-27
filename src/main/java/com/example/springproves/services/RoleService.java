package com.example.springproves.services;

import com.example.springproves.models.filmfy.Role;
import com.example.springproves.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    protected final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id){
        return roleRepository.findById(id);
    }
}
