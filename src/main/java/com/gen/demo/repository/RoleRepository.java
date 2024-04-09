package com.gen.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.demo.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}

