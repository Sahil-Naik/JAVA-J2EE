package com.wipro.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DemoController {

    @GetMapping("/default")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Welcome to API Gateaway");
    }

}
