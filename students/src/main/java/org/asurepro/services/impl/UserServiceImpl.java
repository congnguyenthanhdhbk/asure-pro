package org.asurepro.services.impl;

import org.asurepro.models.User;
import org.asurepro.repository.UserRepository;
import org.asurepro.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(final String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(final String email) {
        return userRepository.existsByEmail(email);
    }
}
