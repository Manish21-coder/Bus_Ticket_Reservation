package com.reservationapp.reservationapp.service;


import com.reservationapp.reservationapp.entity.Bus;
import com.reservationapp.reservationapp.entity.Route;
import com.reservationapp.reservationapp.exception.ResourseNotFound;
import com.reservationapp.reservationapp.payload.RouteDto;
import com.reservationapp.reservationapp.repository.BusRepository;
import com.reservationapp.reservationapp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;


   Route mapTOEntity(RouteDto routeDto){
       Route r = new Route();
       r.setToTime(routeDto.getToTime());
       r.setTotalDuration(routeDto.getTotalDuration());
       r.setFromTime(routeDto.getFromTime());
       r.setToDate(routeDto.getToDate());
       r.setFromDate(routeDto.getFromDate());
       r.setFromLocation(routeDto.getFromLocation());
       r.setToLocation(routeDto.getToLocation());
       r.setId(routeDto.getId());
       r.setBusId(routeDto.getBusId());
       return r;
   }

    public RouteDto createRoute(long busId,RouteDto routeDto){
        Bus bus = busRepository.findById(busId).orElseThrow(

                ()->new ResourseNotFound("Bus Not added")
        );

        Route route = routeRepository.findByBusId(routeDto.getBusId());

        if(route !=null){
            throw new ResourseNotFound("Route was already added");
        }
        if(route==null){
            routeRepository.save(mapTOEntity(routeDto));
            return routeDto;
        }

        return null;

    }
}
