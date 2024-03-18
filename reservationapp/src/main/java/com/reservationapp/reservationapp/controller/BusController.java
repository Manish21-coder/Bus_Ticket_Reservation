package com.reservationapp.reservationapp.controller;

import com.reservationapp.reservationapp.entity.Bus;
import com.reservationapp.reservationapp.entity.Route;
import com.reservationapp.reservationapp.entity.SubRoute;
import com.reservationapp.reservationapp.payload.BusDto;
import com.reservationapp.reservationapp.payload.SearchListOfBusesDto;
import com.reservationapp.reservationapp.repository.BusRepository;
import com.reservationapp.reservationapp.repository.RouteRepository;
import com.reservationapp.reservationapp.repository.SubRouteRepository;
import com.reservationapp.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private BusService busService;
    
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;


    //http://localhost:8080/api/v1/bus/add
    @PostMapping("/add")
    public ResponseEntity<BusDto> addBusDetails(@RequestBody BusDto busDto) throws ParseException {

        BusDto dto = busService.addBuss(busDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }


    //http://localhost:8080/api/v1/bus?fromLocation=&toLocation=&fromDate=
    @GetMapping
    public List<SearchListOfBusesDto> getAllBuses(
            @RequestParam String fromLocation,
            @RequestParam String toLocation,
            @RequestParam String fromDate){

        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);

        List<SearchListOfBusesDto> buses = new ArrayList<>();

        if(routes !=null){

             for(Route route : routes){

               Bus bus =  busRepository.findById(route.getBusId()).get();
                 SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus,route);
               buses.add(searchListOfBusesDto);
             }
             return buses;

        }
        if(subRoutes !=null){

            for(SubRoute subRoute : subRoutes){

                Bus bus =  busRepository.findById(subRoute.getBusId()).get();
                SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus,subRoute);
                buses.add(searchListOfBusesDto);
            }
            return buses;
        }



        return null;
    }


    SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus,Route route){


        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getBusId());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());

        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setToTime(route.getToTime());
        searchListOfBusesDto.setRouteId(route.getId());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());

        return searchListOfBusesDto;

    }

    SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus,SubRoute route){


        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getBusId());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());

        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setToTime(route.getToTime());
        searchListOfBusesDto.setRouteId(route.getId());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());

        return searchListOfBusesDto;

    }



}

