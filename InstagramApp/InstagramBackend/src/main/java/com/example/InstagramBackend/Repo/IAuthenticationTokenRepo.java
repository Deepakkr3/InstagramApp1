package com.example.InstagramBackend.Repo;

import com.example.InstagramBackend.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationTokenRepo extends JpaRepository<AuthenticationToken,Long> {
}
