package com.flightbookingservice.controller;

import com.flightbookingservice.dto.FlightBookingAcknowledgement;
import com.flightbookingservice.dto.FlightBookingRequest;
import com.flightbookingservice.service.FlightBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FlightBookingController {

    private FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }
    @PostMapping("/bookFlightTicket")
    public ResponseEntity<FlightBookingAcknowledgement> bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest){
        return new ResponseEntity<>(flightBookingService.bookFlightTicket(flightBookingRequest), HttpStatus.CREATED);
    }
}
