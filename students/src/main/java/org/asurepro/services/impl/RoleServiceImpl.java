package org.asurepro.services.impl;

import org.asurepro.models.ERole;
import org.asurepro.models.Role;
import org.asurepro.repository.RoleRepository;
import org.asurepro.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(final ERole name) {
        return roleRepository.findByName(name);
    }
}
