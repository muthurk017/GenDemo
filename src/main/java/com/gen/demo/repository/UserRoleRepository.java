package com.gen.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.demo.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}

