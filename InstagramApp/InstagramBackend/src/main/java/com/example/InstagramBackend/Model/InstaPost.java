package com.example.InstagramBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
public class InstaPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String postData;

    @ManyToOne
  //  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_UserId")
    private InstaUser userId;
}
