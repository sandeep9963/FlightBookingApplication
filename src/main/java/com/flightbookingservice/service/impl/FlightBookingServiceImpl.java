package com.flightbookingservice.service.impl;

import com.flightbookingservice.dto.FlightBookingAcknowledgement;
import com.flightbookingservice.dto.FlightBookingRequest;
import com.flightbookingservice.model.PassengerInfo;
import com.flightbookingservice.model.PaymentInfo;
import com.flightbookingservice.repository.PassengerInfoRepository;
import com.flightbookingservice.repository.PaymentInfoRepository;
import com.flightbookingservice.service.FlightBookingService;
import com.flightbookingservice.utils.PaymentUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

    private PassengerInfoRepository passengerInfoRepository;
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingServiceImpl(PassengerInfoRepository passengerInfoRepository, PaymentInfoRepository paymentInfoRepository) {
        this.passengerInfoRepository = passengerInfoRepository;
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Override
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest) {
        FlightBookingAcknowledgement flightBookingAcknowledgement = null;
        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
        if(PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare())){
            paymentInfo.setPassengerId(passengerInfo.getPId());
            paymentInfo.setAmount(passengerInfo.getFare());
            paymentInfo = paymentInfoRepository.save(paymentInfo);
        }
        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
