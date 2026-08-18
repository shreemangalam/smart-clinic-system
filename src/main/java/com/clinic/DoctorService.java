package com.clinic;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    // Returns available time slots for doctor on a given date
    public List<String> getAvailableTimeSlots(Long doctorId, String date) {
        // Mock returning time slots
        return List.of("09:00 AM", "10:00 AM", "02:00 PM");
    }

    // Validates doctor login credentials and returns structured response
    public Map<String, Object> validateDoctorLogin(String email, String password) {
        if ("doctor@clinic.com".equals(email) && "password123".equals(password)) {
            return Map.of("status", "success", "token", "mock-jwt-token-here");
        }
        return Map.of("status", "error", "message", "Invalid credentials");
    }
}
