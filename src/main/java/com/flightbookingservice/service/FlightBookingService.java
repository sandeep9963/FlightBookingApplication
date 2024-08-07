package com.flightbookingservice.service;

import com.flightbookingservice.dto.FlightBookingAcknowledgement;
import com.flightbookingservice.dto.FlightBookingRequest;

public interface FlightBookingService {
    FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest);
}
