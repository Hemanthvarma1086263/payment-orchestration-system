package com.hemanth.paymentapp.provider;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ProviderBService {
    public String processPayment() {

        Random random = new Random();

        if (random.nextBoolean()) {
            return "SUCCESS";
        } else {
            return "FAILED";
        }
    }
	

}
