package com.jav103.jav103_sum25_demo2.services;

import com.jav103.jav103_sum25_demo2.entity.Department;
import com.jav103.jav103_sum25_demo2.repository.DepartmentRepository;

import java.util.List;

public class DepartmentServices {

    private final DepartmentRepository departmentRepository = new DepartmentRepository();

    public List<Department> getDepartments() {
        return departmentRepository.getDepartments();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.getDepartmentById(id);
    }
}
