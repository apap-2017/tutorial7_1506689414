package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

import com.example.model.StudentModel;

@Service
public class StudentDAOImpl implements StudentDAO {

		@Autowired
		private RestTemplate restTemplate;
	
	
	@Override
	public StudentModel selectStudent (String npm) {
		StudentModel student = 
				restTemplate.getForObject(
				"http://localhost:8080/rest/student/view/"+npm, 
				StudentModel.class);
		return student;
		
	}
	
	
	
	//LATIHAN 3
	@Override
	public List<StudentModel> selectAllStudents () {
		
		
		ResponseEntity<StudentModel[]> response = restTemplate.getForEntity("http://localhost:8080/rest/student/viewall", StudentModel[].class);
		return Arrays.asList(response.getBody());
	
		
	}
		
}
