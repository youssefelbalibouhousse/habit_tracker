package org.youssef.habit_tracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.youssef.habit_tracker.model.Role;

import java.util.Optional;

/**
 * Interface JPA pour la gestion des roles.
 *
 * Elle permet de trouver un role par son nom.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(Role.ERole name);
}
