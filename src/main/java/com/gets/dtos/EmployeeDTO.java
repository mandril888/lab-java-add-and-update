package com.gets.dtos;

import com.gets.Enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EmployeeDTO {
    @Enumerated(EnumType.STRING)
    Status status;
    String department;
}
