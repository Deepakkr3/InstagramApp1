package com.example.InstagramBackend.Controller;

import com.example.InstagramBackend.Model.InstaPost;
import com.example.InstagramBackend.Service.InstaPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

         @Autowired
        InstaPostService instaPostService;

         @PostMapping("post")
        public String instaPosts(@RequestBody InstaPost instaPost){
             return  instaPostService.instaPosts(instaPost);
         }

         @GetMapping("get/{id}")
       public Optional<InstaPost> InstGetPost(@PathVariable Long id){
              return instaPostService.InstGetPost(id);
         }

}
