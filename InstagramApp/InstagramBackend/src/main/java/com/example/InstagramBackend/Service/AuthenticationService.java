package com.example.InstagramBackend.Service;

import com.example.InstagramBackend.Model.AuthenticationToken;
import com.example.InstagramBackend.Repo.IAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
     IAuthenticationTokenRepo iAuthenticationTokenRepo;

//    public  void createToken(AuthenticationToken token) {
//        iAuthenticationTokenRepo.save(token);
//    }
}
