package com.example.springproves.services;

import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.Entities;
import com.example.springproves.models.filmfy.Role;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.repositories.CommentRepository;
import com.example.springproves.repositories.EntitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntitiesService {

    protected final EntitiesRepository entitiesRepository;

    public EntitiesService(EntitiesRepository entitiesRepository) {
        this.entitiesRepository = entitiesRepository;
    }

    public List<Entities> getAll() {
        return entitiesRepository.findAll();
    }

    public List<Entities> getEntitiesByRole(Long roleId){
        return entitiesRepository.findByRolesId(roleId);
    }

    public List<Entities> getEntitiesByNameLike(String name){
        return entitiesRepository.findByNameContaining(name);
    }


}
