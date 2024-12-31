package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		model.addAttribute("student", new Student());
		return "student/add";
	}

	@PostMapping("/add")
	public String saveStudent(@ModelAttribute("student") Student student) {
		Student newStudent = studentService.saveStudent(student);
		log.debug("The new added student : {}", newStudent);
		return "redirect:/students/findAll";
	}

	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		log.debug("The list of students : {}", students);
		return "student/list";
	}

	@GetMapping("/findByID/{id}")
	public String findStudentById(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.findStudentByID(id));
		return "student/list";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		Student student = studentService.findStudentByID(id);
		model.addAttribute("student", student);
		return "student/edit";
	}

	@PostMapping("/edit/{id}")
	public String updateByStudentId(@PathVariable("id") int id, @ModelAttribute("student") Student student) {
		studentService.updateStudentByID(id, student);
		return "redirect:/students/findAll";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudentByID(@PathVariable("id") int id) {
		studentService.deleteStudentByID(id);
		return "redirect:/students/findAll";
	}
}
