package org.asurepro.services.impl;

import org.asurepro.models.ERole;
import org.asurepro.models.Role;
import org.asurepro.models.User;
import org.asurepro.payload.request.SignupRequest;
import org.asurepro.repository.RoleRepository;
import org.asurepro.repository.UserRepository;
import org.asurepro.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private static final String ROLE_ADMIN = "admin";
    private static final String ROLE_MENTOR = "mentor";
    private static final String ROLE_STUDENT = "student";
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(final UserRepository userRepository,
                           final PasswordEncoder encoder,
                           final RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(SignupRequest register) {
        // Create new user's account
        User user = new User(register.getUsername(),
                register.getEmail(),
                encoder.encode(register.getPassword()));

        Set<String> strRoles = register.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case ROLE_ADMIN:
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case ROLE_MENTOR:
                        Role modRole = roleRepository.findByName(ERole.ROLE_MENTOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
    }
}
