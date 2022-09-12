package com.gmail.jenya.isa.StudentSite.controller;

import com.gmail.jenya.isa.StudentSite.model.Student;
import com.gmail.jenya.isa.StudentSite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getListOfStudents();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
}
