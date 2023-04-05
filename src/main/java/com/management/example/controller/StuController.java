package com.management.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.example.entity.Student;
import com.management.example.service.StuService;

import jakarta.servlet.http.HttpSession;


@Controller
public class StuController {
	@Autowired
	private StuService service;
	@GetMapping("/")
	  public String home(Model m) {
		
		List<Student> stu=service.getAllStu();
		m.addAttribute("stu",stu);
		  return "index";
	  }
	@GetMapping("/addstu")
	public String addStuForm() {
		return "add_stu";	
	}
	@PostMapping("/register")
	public String stuRegister(@ModelAttribute Student s,HttpSession session) {
		System.out.println(s);
		service.addStu(s);
		session.setAttribute("msg","Student Added Succesfully...");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Student s =service.getStuById(id);
		m.addAttribute("stu", s);
		return "edit";
	}
	@PostMapping("/update")
	public String updateStu(@ModelAttribute Student s,HttpSession session) {
		service.addStu(s);
		session.setAttribute("msg","Student Data Update Succesfully...");
		return "redirect:/";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteStu(@PathVariable int id,HttpSession session) {
		service.deleteStu(id);
		session.setAttribute("msg","Student Data Delete Succesfully...");
		return "redirect:/";
		
	}
}
