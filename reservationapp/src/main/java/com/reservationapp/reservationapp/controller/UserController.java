package com.reservationapp.reservationapp.controller;


import com.reservationapp.reservationapp.entity.UserRegistration;
import com.reservationapp.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.reservationapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;



    @PostMapping
    public String creatUser(
            @RequestParam("name") String name ,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilepicture")MultipartFile profilepicture

            ){

        try{
            UserRegistration userRegistration = new UserRegistration();

            userRegistration.setName(name);
            userRegistration.setEmail(email);
            userRegistration.setPassword(password);
            userRegistration.setProfilepicture(profilepicture.getBytes());
            userService.createUser(userRegistration);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "Done";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readUser(@PathVariable("id") long id) throws Exception{

        UserRegistrationDto readuser = userService.readuser(id);

        return  new ResponseEntity<>(readuser, HttpStatus.OK);
    }

}
