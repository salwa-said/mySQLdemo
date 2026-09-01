package com.cl.mysqldemo.controllers;


import com.cl.mysqldemo.dto.StudentDTO;
import com.cl.mysqldemo.entities.Student;
import com.cl.mysqldemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("add")
    public Long addStudent(
            @RequestParam String name,
            @RequestParam String major,
            @RequestParam String gender,
            @RequestParam String phoneNumber,
            @RequestParam String parentName,
            @RequestParam Long schoolId
    ){
        return studentService.addStudent(name, major, gender, phoneNumber, parentName, schoolId);
    }

    @GetMapping("getAll")
    public List<StudentDTO> getAllStudents() {
        return StudentDTO.convrToDTO(studentService.getAllStudents());
    }

    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id) {
        return StudentDTO.convrToDTO(studentService.getById(id));
    }

    @PutMapping("update")
    public StudentDTO updateStudent(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String major,
            @RequestParam String gender,
            @RequestParam String phoneNumber,
            @RequestParam String parentName,
            @RequestParam Long schoolId
    ) {
        return StudentDTO.convrToDTO(studentService.updateStudent(id, name, major, gender, phoneNumber, parentName, schoolId));
    }

    @DeleteMapping
    public Boolean deleteStudent(@RequestParam Long id) {
        return studentService.deleteById(id);
    }



}
