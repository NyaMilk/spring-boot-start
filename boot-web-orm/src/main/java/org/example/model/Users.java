package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
//    private BigInteger id;
    private String firstname;
    private String lastname;
    private String password;
    private String phone;
}
