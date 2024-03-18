package com.reservationapp.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity@Data@NoArgsConstructor@AllArgsConstructor@Table(name = "user_registration")
public class UserRegistration {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    private String password;

    @Lob
    @Column(length =  10235353) // 10 MB in bytes
    private byte[] profilepicture;

}
