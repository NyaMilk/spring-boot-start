package org.example.service;

import org.example.model.Authentications;
import org.example.repository.AuthRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean checkForTest() {
        Authentications auth = new Authentications();
        auth.setIp("1.1.1.1");
        auth.setIdUser(BigInteger.valueOf(1));
        authRepository.save(auth);

        return true;
    }
}
