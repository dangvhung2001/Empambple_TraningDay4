package com.example.example_trainningday4.service.serviceimpl;

import com.example.example_trainningday4.modal.Role;
import com.example.example_trainningday4.repository.RoleRepository;
import com.example.example_trainningday4.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceIMPL implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceIMPL(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }
}
