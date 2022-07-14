package org.asurepro.services;


import org.asurepro.payload.request.SignupRequest;

public interface AuthService {
    void registerUser(final SignupRequest register);
}
