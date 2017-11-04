package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.CourseModel;

@Service
public class CourseDAOImpl implements CourseDAO {
	
	
	//ditambahin ini karena RestTemplate nya error
	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
		@Autowired
		private RestTemplate restTemplate;
		
		

		@Override
		public CourseModel selectCourse(String id_course) {
			CourseModel course = 
					restTemplate.getForObject(
					"http://localhost:8080/rest/course/view/"+id_course, 
					CourseModel.class);
			return course;
			
		}
		
		@Override
		public List<CourseModel> selectAllCourses () {
					
			ResponseEntity<CourseModel[]> response = restTemplate.getForEntity("http://localhost:8080/rest/course/viewall", CourseModel[].class);
			return Arrays.asList(response.getBody());
			
		}
}

