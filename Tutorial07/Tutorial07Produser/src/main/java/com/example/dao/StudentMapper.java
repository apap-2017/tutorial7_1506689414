package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

@Mapper
public interface StudentMapper
{
	
  //Untuk mengisi List<CourseModel> courses
    @Select("select npm, name, gpa from student where npm = #{npm}")
    @Results (value = {
    		@Result (property="npm", column="npm"),
    		@Result (property="name", column="name"),
    		@Result (property="gpa", column="gpa"),
    		@Result (property="courses", column="npm", 
    		javaType = List.class, many= @Many(select= "selectCourses"))
    })
    StudentModel selectStudent (@Param("npm") String npm);
   
    
    //Untuk viewall
    @Select("select npm, name, gpa from student")
    @Results (value = {
    		@Result (property="npm", column="npm"),
    		@Result (property="name", column="name"),
    		@Result (property="gpa", column="gpa"),
    		@Result (property="courses", column="npm", 
    		javaType = List.class, many= @Many(select= "selectCourses"))
    })
    List<StudentModel> selectAllStudents ();

  
    @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    void addStudent (StudentModel student);
   
    //DELETE
    @Delete ("DELETE from STUDENT WHERE npm = #{npm}")
    void deleteStudent(@Param("npm") String npm);
    
    //UPDATE
    @Update ("UPDATE STUDENT SET name=#{name}, gpa=#{gpa} WHERE npm=#{npm}") 
    void updateStudent(StudentModel student);
 
    //Mengembalikan List of Course dari Student dengan NPM tertentu
    @Select("select course.id_course, name, credits " + 
    "from course join studentcourse " + 
    "on studentcourse.id_course = course.id_course "  + 
    "where studentcourse.npm = #{npm}")
    List<CourseModel> selectCourses (@Param("npm") String npm);
    
    
}
