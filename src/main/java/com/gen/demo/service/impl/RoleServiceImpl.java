package com.gen.demo.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gen.demo.domain.Role;
import com.gen.demo.repository.RoleRepository;
import com.gen.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
    }

    @Override
    @Transactional
    public Role updateRole(String id, Role role) {
        Role existingRole = getRoleById(id);
        // Update existingRole with new data from role
        existingRole.setRoleName(role.getRoleName());
        existingRole.setRoleDescription(role.getRoleDescription());
        existingRole.setRoleDisplayName(role.getRoleDisplayName());
        return roleRepository.save(existingRole);
    }

    @Override
    @Transactional
    public void deleteRole(String id) {
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }
}
