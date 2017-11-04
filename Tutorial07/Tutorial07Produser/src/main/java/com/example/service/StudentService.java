package com.example.service;

import java.util.List;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);


    List<StudentModel> selectAllStudents ();


    void addStudent (StudentModel student);

    //DELETE
    void deleteStudent (String npm);
    
    //UPDATE
    void updateStudent(StudentModel student);
    
    
}
