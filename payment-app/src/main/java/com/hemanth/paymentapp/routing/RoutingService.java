package com.hemanth.paymentapp.routing;

import org.springframework.stereotype.Service;

@Service
public class RoutingService {
	
	
	  public String route(String paymentMethod){

	        if ("CARD".equalsIgnoreCase(paymentMethod)) {
	            return "PROVIDER_A";
	        } else if ("UPI".equalsIgnoreCase(paymentMethod)) {
	            return "PROVIDER_B";
	        } else {
	            return "UNKNOWN";
	        }
	    }
}
