package com.clinic;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String specialty;

    // Defines availableTimes field with correct type and annotation
    @ElementCollection
    @CollectionTable(name = "doctor_availability", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "available_time")
    private List<String> availableTimes;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<String> getAvailableTimes() { return availableTimes; }
    public void setAvailableTimes(List<String> availableTimes) { this.availableTimes = availableTimes; }
}
