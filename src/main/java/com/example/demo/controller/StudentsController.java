package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentsDTO;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.service.StudentsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
//"     api/v1"
public class StudentsController {

	@Autowired(required = false)
	StudentsService studentService;

	@Autowired(required = false)
	StudentsRepository studentRepository;

	@GetMapping(value = "students", produces = "application/json")
	public List<StudentsDTO> getList() {
		return studentService.getList();
	}

	@PostMapping(value = "students", produces = "application/json", consumes = "application/json")
	public StudentsDTO add(@RequestBody StudentsDTO studentAdd) {
		return studentService.add(studentAdd);
	}

	@PutMapping(value = "students", produces = "application/json", consumes = "application/json")
	public StudentsDTO update(@RequestBody StudentsDTO studentUpdate) {
		return studentService.update(studentUpdate);
	}

	@DeleteMapping(value = "students/{id}", produces = "application/json")
	public void delete(@PathVariable("id") int id) {
		studentService.deleteById(id);
	}

	@GetMapping(value = "students/{id}", produces = "application/json")
	public StudentsDTO getById(@PathVariable("id") long id) {
		return studentService.getById(id);
	}
}
