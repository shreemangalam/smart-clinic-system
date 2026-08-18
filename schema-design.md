# MySQL Database Schema Design

## 1. Table: `doctors`
* `doctor_id` (INT, Primary Key, Auto Increment)
* `name` (VARCHAR)
* `specialty` (VARCHAR)
* `email` (VARCHAR, Unique)

## 2. Table: `patients`
* `patient_id` (INT, Primary Key, Auto Increment)
* `name` (VARCHAR)
* `email` (VARCHAR, Unique)
* `phone_number` (VARCHAR)

## 3. Table: `appointments`
* `appointment_id` (INT, Primary Key, Auto Increment)
* `doctor_id` (INT, Foreign Key referencing `doctors(doctor_id)`)
* `patient_id` (INT, Foreign Key referencing `patients(patient_id)`)
* `appointment_time` (DATETIME)
* `status` (VARCHAR)

## 4. Table: `prescriptions`
* `prescription_id` (INT, Primary Key, Auto Increment)
* `appointment_id` (INT, Foreign Key referencing `appointments(appointment_id)`)
* `medication_details` (TEXT)
* `instructions` (TEXT)
