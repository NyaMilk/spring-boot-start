package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Authentications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    private BigInteger idUser;
    private Timestamp date;
    private String ip;
}
