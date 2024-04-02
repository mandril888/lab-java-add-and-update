package com.gets.service;

import com.gets.Enums.Status;
import com.gets.model.Employee;
import com.gets.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getEmployeeByStatus(Status status) {
        return employeeRepo.findByStatus(status);
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }

    public void addNewEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public void updateEmployeeStatus(int id, Status status) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employee.get().setStatus(status);
            employeeRepo.save(employee.get());
        }
    }

    public void updateEmployeeDepartment(int id, String department) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employee.get().setDepartment(department);
            employeeRepo.save(employee.get());
        }
    }
}
