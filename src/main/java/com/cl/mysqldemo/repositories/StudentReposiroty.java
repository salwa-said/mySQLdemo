package com.cl.mysqldemo.repositories;


import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReposiroty extends JpaRepository<Student, Long> {
}
