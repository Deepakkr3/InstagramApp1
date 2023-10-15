package com.example.InstagramBackend.Service;

import com.example.InstagramBackend.Model.InstaPost;
import com.example.InstagramBackend.Repo.InstaPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstaPostService {

       @Autowired
       InstaPostRepo instaPostRepo;


       public Optional<InstaPost> InstGetPost(Long id) {
          return   instaPostRepo.findById(id);
       }

    public String instaPosts(InstaPost instaPost) {
           instaPostRepo.save(instaPost);
           return  "post successfully";
    }
}
