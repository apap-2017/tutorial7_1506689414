package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {
	private String id_course;
	private String name;
	private Integer credits;
	private List<StudentModel> students;
	
	
    
    public String getId_course() {
  		return id_course;
      	
    }
      
    public void setGpa(String id_course) {
      	this.id_course=id_course;
    }
    
    public String getName() {
  		return name;
      	
    }
      
    public void setName(String name) {
      	this.name=name;
    }
    
    public int getCredits() {
  		return credits;
      	
    }
      
    public void setCredits(int credits) {
      	this.credits=credits;
    }
	
}
