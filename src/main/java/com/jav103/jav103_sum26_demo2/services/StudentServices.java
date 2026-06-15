package com.jav103.jav103_sum26_demo2.services;

import com.jav103.jav103_sum26_demo2.entity.Student;
import com.jav103.jav103_sum26_demo2.repository.StudentRepository;

import java.util.List;

public class StudentServices {

    private final StudentRepository studentRepository = new StudentRepository();

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);

    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void editStudent(Student student) {
        studentRepository.editStudent(student);
    }
}
