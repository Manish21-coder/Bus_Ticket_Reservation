package com.reservationapp.reservationapp.service;


import com.reservationapp.reservationapp.entity.Bus;
import com.reservationapp.reservationapp.entity.Route;
import com.reservationapp.reservationapp.entity.SubRoute;
import com.reservationapp.reservationapp.payload.BusDto;
import com.reservationapp.reservationapp.payload.RouteDto;
import com.reservationapp.reservationapp.payload.SubRouteDto;
import com.reservationapp.reservationapp.repository.BusRepository;
import com.reservationapp.reservationapp.repository.RouteRepository;
import com.reservationapp.reservationapp.repository.SubRouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Autowired
    private ModelMapper modelMapper;



  //  @Transactional
    public BusDto addBuss(BusDto busDto) {
        // Convert BusDto to Bus entity
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        Bus b = busRepository.save(bus);
        return  modelMapper.map(b,BusDto.class);
    }
    }


