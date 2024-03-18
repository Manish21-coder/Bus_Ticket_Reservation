package com.reservationapp.reservationapp.service;


import com.reservationapp.reservationapp.entity.UserRegistration;
import com.reservationapp.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.reservationapp.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    public UserRegistrationRepository userRegistrationRepository;



    public UserRegistrationDto createUser(UserRegistration userRegistration){

        userRegistrationRepository.save(userRegistration);
        return  null;


    }

    public UserRegistrationDto readuser(long id) {
        UserRegistration userRegistration = userRegistrationRepository.findById(id).get();
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setId(userRegistration.getId());
        userRegistrationDto.setName(userRegistration.getName());
        userRegistrationDto.setEmail(userRegistration.getEmail());
        userRegistrationDto.setPassword(userRegistration.getPassword());
        userRegistrationDto.setProfilepicture(userRegistration.getProfilepicture());

        return userRegistrationDto;
    }
}
