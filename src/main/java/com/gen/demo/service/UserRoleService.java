package com.gen.demo.service;

import com.gen.demo.domain.UserRole;

public interface UserRoleService {
    UserRole createUserRole(UserRole userRole);
    UserRole getUserRoleById(String id);
    UserRole updateUserRole(String id, UserRole userRole);
    void deleteUserRole(String id);
}

