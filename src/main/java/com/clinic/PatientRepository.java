package com.clinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Retrieves patient by email using derived query
    Optional<Patient> findByEmail(String email);

    // Retrieves patient using either email or phone number
    Optional<Patient> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
