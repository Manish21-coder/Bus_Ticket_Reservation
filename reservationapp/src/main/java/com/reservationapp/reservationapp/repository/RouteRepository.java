package com.reservationapp.reservationapp.repository;

import com.reservationapp.reservationapp.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RouteRepository extends JpaRepository<Route, Long> {
  Route findByBusId(long BusId);

  List<Route> findByFromLocationAndToLocationAndFromDate(String fromLocation,String toLocation,String fromDate);

}

