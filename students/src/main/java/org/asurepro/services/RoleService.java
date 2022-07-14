package org.asurepro.services;

import org.asurepro.models.ERole;
import org.asurepro.models.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(ERole name);
}
