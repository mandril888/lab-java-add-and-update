package com.gets.controller;

import com.gets.Enums.Status;
import com.gets.dtos.EmployeeDTO;
import com.gets.model.Employee;
import com.gets.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployeeById(@PathVariable(name="id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByStatus(@PathVariable(name="status")Status status) {
        return employeeService.getEmployeeByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@PathVariable(name="department")String department) {
        return employeeService.getEmployeeByDepartment(department);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewEmployee(@RequestBody @Valid Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @PatchMapping("/employees/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable(name="id") int id, @RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO.getStatus() != null) {
            employeeService.updateEmployeeStatus(id, employeeDTO.getStatus());
        }
        if (employeeDTO.getDepartment() != null) {
            employeeService.updateEmployeeDepartment(id, employeeDTO.getDepartment());
        }
    }

}
