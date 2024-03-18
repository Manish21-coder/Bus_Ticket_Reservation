package com.reservationapp.reservationapp.repository;

import com.reservationapp.reservationapp.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
