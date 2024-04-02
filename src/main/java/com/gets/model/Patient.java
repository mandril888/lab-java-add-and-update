package com.gets.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employeeId")
    private Employee admittedBy;
}
