package org.example.controller;

import org.example.model.Users;
import org.example.repository.UserRepository;
import org.example.service.AuthService;
import org.example.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {
    private final UsersService usersService;
    private final UserRepository userRepository;

    public Controller(UsersService usersService, UserRepository userRepository) {
        this.usersService = usersService;
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public ResponseEntity<?> getDates() {
//        String name = "Test1";
//        Users users = userRepository.findByFirstname(name);
//
//        Users newUser = new Users();
//        newUser.setFirstname("Test2");
//        newUser.setLastname("Test2");
//        newUser.setPassword("Test2");
//        userRepository.save(newUser);
        usersService.checkForTest("Test1");

        return ResponseEntity.ok().body("");
    }
}
