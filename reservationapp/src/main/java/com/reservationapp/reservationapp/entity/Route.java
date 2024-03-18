package com.reservationapp.reservationapp.entity;


import lombok.*;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    @Column(name = "bus_id",unique = true,nullable = false)
    private Long busId;




}
