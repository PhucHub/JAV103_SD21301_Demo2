package com.jav103.jav103_sum25_demo2.services;

import com.jav103.jav103_sum25_demo2.entity.Employee;
import com.jav103.jav103_sum25_demo2.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServices {

    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee);
    }
}
