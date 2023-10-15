package com.example.InstagramBackend.Repo;

import com.example.InstagramBackend.Model.InstaUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstaUserRepo extends JpaRepository<InstaUser,Long> {

         InstaUser findByEmail(String newEmail);
}

