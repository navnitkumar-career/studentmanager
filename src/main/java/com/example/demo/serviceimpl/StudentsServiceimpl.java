package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentsDTO;
import com.example.demo.model.Students;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.service.StudentsService;

@Service
public class StudentsServiceimpl implements StudentsService {

	@Autowired
	StudentsRepository studentsRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public List<StudentsDTO> getList() {

		List<Students> studentsList = studentsRepository.findAll();

		List<StudentsDTO> studentsDtoList = studentsList.stream().map(t -> {
			StudentsDTO studentsDto = new StudentsDTO();
			modelMapper.map(t, studentsDto);
			return studentsDto;
		}).collect(Collectors.toList());
		return studentsDtoList;
	}

	@Override
	@Transactional
	public StudentsDTO add(StudentsDTO studentAdd) {
		Students student = new Students();
		modelMapper.map(studentAdd, student);
		studentsRepository.save(student);
		modelMapper.map(student, studentAdd);
		return studentAdd;
	}

	@Override
	@Transactional
	public StudentsDTO update(StudentsDTO studentUpdate) {
		Students student = studentsRepository.findById(studentUpdate.getId()).get();
		modelMapper.map(studentUpdate, student);
		studentsRepository.save(student);
		modelMapper.map(student, studentUpdate);
		return studentUpdate;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		studentsRepository.deleteById(id);
	}

	@Override
	@Transactional
	public StudentsDTO getById(long id) {
		Students student = studentsRepository.findById(id).get();
	StudentsDTO stud=new StudentsDTO();
	modelMapper.map(student, stud);
		return stud;
	}

}
