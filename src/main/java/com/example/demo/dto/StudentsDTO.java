package com.example.demo.dto;

public class StudentsDTO {
	
	Long id;
	String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + "]";
	}

}
