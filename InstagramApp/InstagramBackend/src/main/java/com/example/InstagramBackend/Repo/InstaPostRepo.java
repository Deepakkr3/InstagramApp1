package com.example.InstagramBackend.Repo;

import com.example.InstagramBackend.Model.InstaPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstaPostRepo extends  JpaRepository<InstaPost,Long>   {

}
