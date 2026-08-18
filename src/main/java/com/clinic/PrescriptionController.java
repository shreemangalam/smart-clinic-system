package com.clinic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // POST endpoint with token and body validation, returning structured response
    @PostMapping
    public ResponseEntity<Map<String, String>> savePrescription(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody PrescriptionRequest request) {
            
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("status", "error", "message", "Invalid Token"));
        }
        
        // Mock save logic
        return ResponseEntity.ok(Map.of("status", "success", "message", "Prescription saved successfully"));
    }
}
