package com.company.groomingzone;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("server response");
    }
}
