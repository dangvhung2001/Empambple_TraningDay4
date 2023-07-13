package com.example.example_trainningday4.service;

import com.example.example_trainningday4.modal.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role save (Role role);

    void deleteById(Long id);

    Role findById(Long id);
}
