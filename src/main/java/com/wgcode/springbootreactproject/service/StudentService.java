package com.wgcode.springbootreactproject.service;

import com.wgcode.springbootreactproject.exception.StudentAlreadyExistsException;
import com.wgcode.springbootreactproject.exception.StudentNotFoundException;
import com.wgcode.springbootreactproject.model.Students;
import com.wgcode.springbootreactproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students addNewStudent(Students students) {

        //check if student already exists
        if (studentAlreadyExists(students.getEmail())){
            throw new StudentAlreadyExistsException( students.getEmail() + "Student already exists!");
        }

        return studentRepository.save(students);
    }


    @Override
    public Students updateStudent(Students student, Long id) { //updating a student in our database
        return studentRepository.findById(id).map(studentExists -> {
            studentExists.setFirstName(student.getFirstName());
            studentExists.setLastName(student.getLastName());
            studentExists.setEmail(student.getEmail());
            studentExists.setDepartment(student.getDepartment());
            return studentRepository.save(studentExists);
        }).orElseThrow(() ->
                new StudentNotFoundException("student not found in database"));
    }

    @Override
    public Students getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("student not found in database with this ID: {}" + id));
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException("student not found");
        }
        studentRepository.deleteById(id);
    }

    private boolean studentAlreadyExists(String emailExists) {
        return studentRepository.findByEmail(emailExists).isPresent();
    }
}
