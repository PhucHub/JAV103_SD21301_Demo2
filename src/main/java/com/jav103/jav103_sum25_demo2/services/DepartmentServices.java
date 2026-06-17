package com.jav103.jav103_sum25_demo2.services;

import com.jav103.jav103_sum25_demo2.entity.Department;
import com.jav103.jav103_sum25_demo2.repository.DepartmentRepository;

import java.util.List;

public class DepartmentServices {
    private DepartmentRepository repository = new DepartmentRepository();

    public List<Department> getDepartments() {
        return repository.getDepartments();
    }

    public Department getDepartmentById(Long id) {
        return repository.getDepartmentById(id);
    }

    public void addDepartment(Department department) {
        repository.addDepartment(department);
    }

    public void updateDepartment(Department department) {
        repository.updateDepartment(department);
    }

    public void deleteDepartment(Long id) {
        repository.deleteDepartment(id);
    }

    public List<Department> searchByName(String keyword) {
        return repository.searchByName(keyword);
    }
}
