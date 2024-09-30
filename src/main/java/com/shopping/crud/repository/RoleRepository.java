package com.shopping.crud.repository;

import com.shopping.crud.model.ERole;
import com.shopping.crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
