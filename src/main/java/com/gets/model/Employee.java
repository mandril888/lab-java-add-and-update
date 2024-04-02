package com.gets.model;

import com.gets.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
}
