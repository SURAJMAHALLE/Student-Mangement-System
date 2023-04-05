package com.management.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.management.example.entity.Student;
@Repository
public interface StuRepo extends JpaRepository<Student,Integer>{

}
