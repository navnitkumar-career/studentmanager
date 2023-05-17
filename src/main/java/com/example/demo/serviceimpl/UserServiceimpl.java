package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public UserDTO Add(UserDTO studentAdd) {

		User exitingEmail = userRepository.getByEmailId(studentAdd.getEmailId());

		if (exitingEmail == null) {
			User student = new User();
			modelMapper.map(studentAdd, student);
			userRepository.save(student);
			modelMapper.map(student, studentAdd);
			return studentAdd;
		} else {
			return null;
		}

	}

	@Override
	@Transactional
	public void deleteById(long id) {
		userRepository.deleteById(id);

	}

	@Override
	public UserDTO loginUser(UserDTO userLogin) {
		User user = userRepository.getByEmailIdAndPassword(userLogin.getEmailId(), userLogin.getPassword());
		if (user == null) {
			return userLogin;
		} else {
			modelMapper.map(user, userLogin);
			return userLogin;
		}
	}

	@Override
	public List<UserDTO> getList() {
		List<User> getList = userRepository.findAll();

		List<UserDTO> getListOfDto = getList.stream().map(t -> {
			UserDTO userdto = new UserDTO();
			modelMapper.map(t, userdto);

			userdto.setPasword(t.getPassword());
			return userdto;
		}).collect(Collectors.toList());
		return getListOfDto;

	}

}
