package com.reservationapp.reservationapp.controller;


import com.reservationapp.reservationapp.entity.Route;
import com.reservationapp.reservationapp.payload.RouteDto;
import com.reservationapp.reservationapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/{busId}")
    public ResponseEntity<RouteDto> addRoute(@PathVariable long busId, @RequestBody RouteDto routeDto){


        RouteDto r = routeService.createRoute(busId, routeDto);
        return new ResponseEntity<>(r , HttpStatus.CREATED);
    }
}
