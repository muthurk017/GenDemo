package com.gen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gen.demo.domain.Role;
import com.gen.demo.domain.UserRole;
import com.gen.demo.service.RoleService;
import com.gen.demo.service.UserRoleService;

@RestController
@RequestMapping("/api")
public class RoleAndUserRoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    // Role APIs

    @PostMapping("/roles")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/roles/{id}")
    public Role getRole(@PathVariable String id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("/roles/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
    }

    // UserRole APIs

    @PostMapping("/userroles")
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleService.createUserRole(userRole);
    }

    @GetMapping("/userroles/{id}")
    public UserRole getUserRole(@PathVariable String id) {
        return userRoleService.getUserRoleById(id);
    }

    @PutMapping("/userroles/{id}")
    public UserRole updateUserRole(@PathVariable String id, @RequestBody UserRole userRole) {
        return userRoleService.updateUserRole(id, userRole);
    }

    @DeleteMapping("/userroles/{id}")
    public void deleteUserRole(@PathVariable String id) {
        userRoleService.deleteUserRole(id);
    }
}
