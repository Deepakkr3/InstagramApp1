package com.example.InstagramBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
public class InstaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private  String password;
    private String phoneNumber;








}
