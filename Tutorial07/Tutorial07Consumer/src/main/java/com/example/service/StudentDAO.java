package com.example.service;

import java.util.List;

import com.example.model.StudentModel;

public interface StudentDAO {
	StudentModel selectStudent (String npm);
	List<StudentModel> selectAllStudents();

}
