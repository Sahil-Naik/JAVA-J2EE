package com.wipro;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ReactiveService {

    public Flux<String> getMessages() {
        return Flux.just("Message 1", "Message 2", "Message 3")
                .delayElements(Duration.ofSeconds(3)); // Simulating delay
    }
}
