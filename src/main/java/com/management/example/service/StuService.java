package com.management.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.example.entity.Student;
import com.management.example.repository.StuRepo;
@Service
public class StuService {
	@Autowired
	private StuRepo repo;
     public void addStu(Student s) {
    	 repo.save(s);
     }
     public List<Student> getAllStu(){
		return repo.findAll();
    	 
     }
     public Student getStuById(int id) {
		Optional<Student> s = repo.findById(id);
    	 if(s.isPresent()) {
    		 return s.get();
    	 }
    	 return null;
     }
     public void deleteStu(int id) {
    	 repo.deleteById(id);
     }
}
