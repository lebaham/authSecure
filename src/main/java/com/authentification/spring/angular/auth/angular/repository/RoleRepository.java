package com.authentification.spring.angular.auth.angular.repository;

import com.authentification.spring.angular.auth.angular.model.Role;
import com.authentification.spring.angular.auth.angular.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
