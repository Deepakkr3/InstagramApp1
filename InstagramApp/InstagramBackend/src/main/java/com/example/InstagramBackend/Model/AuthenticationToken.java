package com.example.InstagramBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalTime tokenCreationTime;


//    @OneToOne
//    @JoinColumn(name = "FK_UserId")
//    private  InstaUser userId  ;
//
//    public AuthenticationToken(InstaUser instaUser) {
//        this.tokenId=tokenId;
//        this.tokenCreationTime = LocalTime.now();
//        this.token= UUID.randomUUID().toString();
//    }
public AuthenticationToken(InstaUser instaUser){
    this.instaUser=instaUser;
    this.tokenCreationTime = LocalTime.now();
    this.token = UUID.randomUUID().toString();
}

    @OneToOne
    @JoinColumn(name = "fk_instaUser_id")
    InstaUser instaUser;
}
