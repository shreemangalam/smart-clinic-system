package com.clinic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // GET endpoint using dynamic parameters, validates token, returns ResponseEntity
    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<Map<String, Object>> getAvailability(
            @RequestHeader("Authorization") String token,
            @PathVariable Long doctorId,
            @RequestParam String date) {
            
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("error", "Unauthorized"));
        }
        
        List<String> slots = doctorService.getAvailableTimeSlots(doctorId, date);
        return ResponseEntity.ok(Map.of("doctorId", doctorId, "date", date, "slots", slots));
    }
}
