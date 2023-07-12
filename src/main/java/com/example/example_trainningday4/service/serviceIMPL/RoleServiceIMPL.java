package com.example.example_trainningday4.service.serviceIMPL;

import com.example.example_trainningday4.modal.Role;
import com.example.example_trainningday4.repository.RoleRepository;
import com.example.example_trainningday4.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceIMPL implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role update(Long id, Role role) {
        return null;
    }
}
