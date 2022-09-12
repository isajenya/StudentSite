package com.gmail.jenya.isa.StudentSite.service;

import com.gmail.jenya.isa.StudentSite.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getListOfStudents();

    public void deleteStudent(int id);
}
