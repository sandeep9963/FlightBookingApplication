package com.flightbookingservice.utils;

import com.flightbookingservice.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>();

    {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 20000.0);
        paymentMap.put("acc4", 30000.0);
    }

    public static boolean validateCreditLimit(String accountNo, double paidAmount){
        if(paidAmount>paymentMap.get(accountNo)){
            throw new InsufficientAmountException("Insufficient Balance...!");
        }else{
            return true;
        }
    }
}
