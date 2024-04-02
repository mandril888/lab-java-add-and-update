package com.gets.controller;

import com.gets.Enums.Status;
import com.gets.model.Patient;
import com.gets.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients() {
        return patientService.findAll();
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatientById(@PathVariable(name="id") int id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/birth-date")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ){
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable("department") String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/patients/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDoctorStatus(@PathVariable("status") String status) {
        Status statusEnum = Status.valueOf(status.toUpperCase());
        return patientService.getPatientsByDoctorStatus(statusEnum);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPatient(@RequestBody @Valid Patient patient) {
        patientService.addNewPatient(patient);
    }

    @PutMapping("/patients/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable(name = "id") int id, @RequestBody Patient patient) {
        patientService.updatePatient(id, patient);
    }
}
