package com.wgcode.springbootreactproject.contoller;

import com.wgcode.springbootreactproject.model.Students;
import com.wgcode.springbootreactproject.service.IStudentService;
import com.wgcode.springbootreactproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService iStudentService;

    @GetMapping
    public ResponseEntity<List<Students>> getStudents(){
        return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.FOUND);
    }

    @PostMapping
    public Students addStudents(@RequestBody Students students){
        return iStudentService.addNewStudent(students);
    }

    @PutMapping("/update/{id}")
    public Students updateStudents(@RequestBody Students students, @PathVariable Long id){
        return iStudentService.updateStudent(students, id);
    }

    @DeleteMapping
    public void deleteStudent(@PathVariable Long id){
        iStudentService.deleteStudentById(id);
    }
}
