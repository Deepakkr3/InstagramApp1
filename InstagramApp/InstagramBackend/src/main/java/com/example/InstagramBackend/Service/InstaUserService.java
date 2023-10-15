package com.example.InstagramBackend.Service;

import com.example.InstagramBackend.Model.AuthenticationToken;
import com.example.InstagramBackend.Model.InstaPost;
import com.example.InstagramBackend.Model.InstaUser;
import com.example.InstagramBackend.Repo.IAuthenticationTokenRepo;
import com.example.InstagramBackend.Repo.InstaUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class InstaUserService {

        @Autowired
        static InstaUserRepo instaUserRepo;

        @Autowired
        AuthenticationService authenticationService;
        @Autowired
        IAuthenticationTokenRepo iAuthenticationTokenRepo;


        public String userSignUp(InstaUser newUser) {

                String newEmail = newUser.getEmail();

                InstaUser existInstaUser = instaUserRepo.findByEmail(newEmail);

                if (existInstaUser != null) {
                        return "email already in use";
                }

                // passwords are encrypted before we store it in the table

                String signUpPassword = newUser.getPassword();

                try {
                        String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

                        newUser.setPassword(encryptedPassword);

                        // patient table - save patient
                        instaUserRepo.save(newUser);
                        return "Instagram  user registered Successfully";

                } catch (NoSuchAlgorithmException e) {

                        return "Internal Server issues while saving password, try again later!!!";
                }
        }
// signIn .....................................................

        public String userSignIn(String email, String password) {


                InstaUser existInstaUser = instaUserRepo.findByEmail(email);

                if(existInstaUser==null){
                        return "Not a valid email, Please sign up first !!!";
                }
                //password should be matched

                try {
                        String encryptedPassword = PasswordEncryptor.encrypt(password);
                        if(existInstaUser.getPassword().equals(encryptedPassword)){
                                // return a token for this sign in
                               AuthenticationToken token =new AuthenticationToken(existInstaUser);
                              iAuthenticationTokenRepo.save(token);
                                return token.getToken();
                        }
                        else{
                                //password was wrong!!!
                                return "Invalid Credentials!!!";
                        }
                } catch (NoSuchAlgorithmException e) {
                        return "Internal Server issues while saving password, try again later!!!";
                }
        }

        public String updateUserName(Long id, String firstName) {
                InstaUser UserUpdate = instaUserRepo.findById(id).orElse(null);
                if (UserUpdate != null) {
                        UserUpdate.setFirstName(firstName);
                        instaUserRepo.save(UserUpdate);
                        return "Wohoo!! User updated successfully";
                }

            return "its not valid id";
        }
}

