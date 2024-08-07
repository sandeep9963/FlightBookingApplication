package com.flightbookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.flightbookingservice")
public class FlightBookingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlightBookingServiceApplication.class, args);
    }
}