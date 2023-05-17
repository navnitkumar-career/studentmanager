package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentsDTO;

public interface StudentsService {

	List<StudentsDTO> getList();

	StudentsDTO add(StudentsDTO studentAdd);

	StudentsDTO update(StudentsDTO studentAdd);

	void deleteById(long id);
	
	StudentsDTO getById(long id);
}
