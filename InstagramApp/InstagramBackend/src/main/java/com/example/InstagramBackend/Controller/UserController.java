package com.example.InstagramBackend.Controller;

import com.example.InstagramBackend.Model.InstaUser;
import com.example.InstagramBackend.Service.InstaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

       @Autowired
     InstaUserService instaUserService;

    @PostMapping("user/signup")
    public String userSignUp(@RequestBody InstaUser newUser)
    {

        return instaUserService.userSignUp(newUser);
    }

    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return instaUserService.userSignIn(email,password);
    }

    @PutMapping("/userName/id/{id}")
    public String updateUserName(@PathVariable  Long id, @RequestParam  String firstName){
        return instaUserService.updateUserName(id, firstName);
    }


}
