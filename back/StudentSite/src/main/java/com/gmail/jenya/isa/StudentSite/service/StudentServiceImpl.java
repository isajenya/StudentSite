package com.gmail.jenya.isa.StudentSite.service;

import com.gmail.jenya.isa.StudentSite.model.Student;
import com.gmail.jenya.isa.StudentSite.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getListOfStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            System.out.println("student with " + id + " doesn`t exists");
            throw new RuntimeException("This student is`nt exists");
        } else {
            studentRepository.deleteById(id);
        }
    }
}
