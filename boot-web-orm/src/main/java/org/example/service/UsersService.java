package org.example.service;

import org.example.model.Authentications;
import org.example.model.Users;
import org.example.repository.AuthRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.math.BigInteger;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkForTest(String name) {
        Users user = userRepository.findByFirstname(name);
        user.setLastname("testTestTestTestTestTestTestTestTest");
        userRepository.save(user);
        return true;
    }
}
