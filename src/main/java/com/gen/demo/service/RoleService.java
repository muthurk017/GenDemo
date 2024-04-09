package com.gen.demo.service;

import com.gen.demo.domain.Role;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(String id);
    Role updateRole(String id, Role role);
    void deleteRole(String id);
}

