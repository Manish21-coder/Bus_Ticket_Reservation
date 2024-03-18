package com.reservationapp.reservationapp.repository;

import com.reservationapp.reservationapp.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {

}
