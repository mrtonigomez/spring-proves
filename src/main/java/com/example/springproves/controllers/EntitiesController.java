package com.example.springproves.controllers;


import com.example.springproves.EntitiesDTO;
import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.Entities;
import com.example.springproves.models.filmfy.Role;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class EntitiesController {

    private ModelMapper modelMapper;
    protected final EntitiesService entitiesService;
    protected final RoleService roleService;
    private final MapStructMapper mapStructMapper;

    public EntitiesController(EntitiesService entitiesService, RoleService roleService, MapStructMapper mapStructMapper, ModelMapper modelMapper) {
        this.entitiesService = entitiesService;
        this.mapStructMapper = mapStructMapper;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @GetMapping("/entities")
    @ResponseBody
    public ResponseEntity getEntities() {

        List<Entities> entities = entitiesService.getAll();

        return ResponseEntity.ok(entities
                .stream()
                .map(entity -> {
                    EntitiesDTO entitiesDTO = modelMapper.map(entity, EntitiesDTO.class);
                    entitiesDTO.setRole(entity.getRoles().getName());
                    return entitiesDTO;
                })
                .collect(Collectors.toList()));
    }

    @GetMapping("/entities2")
    @ResponseBody
    public ResponseEntity getEntitiesByParam(@RequestParam String filter) {

        List<Entities> entities = entitiesService.getEntitiesByNameLike(filter);

        return ResponseEntity.ok(entities
                .stream()
                .map(entity -> {
                    EntitiesDTO entitiesDTO = modelMapper.map(entity, EntitiesDTO.class);
                    entitiesDTO.setRole(entity.getRoles().getName());
                    return entitiesDTO;
                })
                .collect(Collectors.toList()));
    }

    @GetMapping("/entities-role/{id}")
    @ResponseBody
    public ResponseEntity getEntitiesByRole(@PathVariable String id) {

        Optional<Role> role = roleService.getRoleById((long) Integer.parseInt(id));

        List<Entities> entities = entitiesService.getEntitiesByRole(role.get().getId());

        return ResponseEntity.ok(entities
                .stream()
                .map(entity -> {
                    EntitiesDTO entitiesDTO = modelMapper.map(entity, EntitiesDTO.class);
                    entitiesDTO.setRole(entity.getRoles().getName());
                    return entitiesDTO;
                })
                .collect(Collectors.toList()));
    }

}