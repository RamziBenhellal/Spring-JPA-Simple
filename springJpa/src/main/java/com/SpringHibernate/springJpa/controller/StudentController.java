package com.SpringHibernate.springJpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringHibernate.springJpa.jpaRepository.StudentRepository;
import com.SpringHibernate.springJpa.model.Student;

@RequestMapping("api/students")
@RestController
public class StudentController {
	
	private final StudentRepository studentRepository;

	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@GetMapping(name = "index")
	public List<Student> index(){
		return studentRepository.findAll();
	}
	
	@PostMapping(name = "add")
	public void add(@RequestBody Student student) {
		studentRepository.save(student);
	}
	
	@GetMapping(name = "details",path = "{id}")
	public Optional<Student> details(@PathVariable("id") Integer id) {
		return studentRepository.findById(id);
	}
	
	@PutMapping(name = "edit", path = "{id}")
	public int edit(@RequestBody Student updatedStudent, @PathVariable("id") Integer id) {
		return studentRepository.findById(id)
		.map( student ->{
			student.setFirstname(updatedStudent.getFirstname());
			student.setLastname(updatedStudent.getLastname());
			studentRepository.flush();
			return 1;
		}).orElse(0);
	}
	
	@DeleteMapping(name = "delete", path = "{id}")
	public void delete(@PathVariable("id") Integer id) {
		studentRepository.deleteById(id);
	}

}
