package com.gmail.jenya.isa.StudentSite.repository;

import com.gmail.jenya.isa.StudentSite.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
