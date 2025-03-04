package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RefreshController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private BusProperties busProperties;

    @SuppressWarnings("deprecation")
	@PostMapping("/refresh")
    public String refresh() {
        // Use the correct types for the constructor
        String originService = busProperties.getId(); // This is usually the application name
        String destinationService = null; // You can specify a service name or leave it null for all

        // Create the event with explicit types
        RefreshRemoteApplicationEvent event = new RefreshRemoteApplicationEvent(this, originService, destinationService);
        publisher.publishEvent(event);
        
        return "Refresh event published!";
    }
}