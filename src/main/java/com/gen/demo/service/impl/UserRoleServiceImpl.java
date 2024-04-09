package com.gen.demo.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gen.demo.domain.UserRole;
import com.gen.demo.repository.UserRoleRepository;
import com.gen.demo.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRoleById(String id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserRole not found with id: " + id));
    }

    @Override
    @Transactional
    public UserRole updateUserRole(String id, UserRole userRole) {
        UserRole existingUserRole = getUserRoleById(id);
        // Update existingUserRole with new data from userRole
        existingUserRole.setUserId(userRole.getUserId());
        existingUserRole.setRoleId(userRole.getRoleId());
        return userRoleRepository.save(existingUserRole);
    }

    @Override
    @Transactional
    public void deleteUserRole(String id) {
        UserRole userRole = getUserRoleById(id);
        userRoleRepository.delete(userRole);
    }
}

