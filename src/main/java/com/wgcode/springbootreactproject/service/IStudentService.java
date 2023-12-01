package com.wgcode.springbootreactproject.service;

import com.wgcode.springbootreactproject.model.Students;

import java.util.List;

public interface IStudentService {
    Students addNewStudent(Students students);

    List<Students> getStudents();
    Students updateStudent(Students student, Long id);
    Students getStudentById(Long id);

    //method to delete a student
    void deleteStudentById(Long id);
}
