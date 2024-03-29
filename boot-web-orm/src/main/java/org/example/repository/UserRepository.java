package org.example.repository;

import org.example.model.Authentications;
import org.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByFirstname(String name);
}
