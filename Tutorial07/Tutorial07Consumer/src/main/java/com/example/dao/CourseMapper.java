package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.example.model.CourseModel;
import com.example.model.StudentModel;


@Mapper
public interface CourseMapper
{
	//untuk mengisi list of students
	   @Select("select id_course, name, credits from course where id_course = #{id_course}")
	    @Results (value = {
	    		@Result (property="id_course", column="id_course"),
	    		@Result (property="name", column="name"),
	    		@Result (property="credits", column="credits"), 
	    		@Result (property="students", column="id_course", 
	    	    javaType = List.class, many= @Many(select= "selectStudents"))
	    })
	    CourseModel selectCourse (@Param("id_course") String id_course);
	   

    @Select("select id_course, name, credits from course")
    List<CourseModel> selectAllCourses ();
 
    
    //Untuk view mahasiswa yg ambil
    @Select("select name, npm, gpa from student")
    @Results (value = {
    		@Result (property="name", column="name"),
    		@Result (property="npm", column="npm"),
    		@Result (property="gpa", column="gpa"),
       		@Result (property="course", column="id_course", 
    		javaType = List.class, many= @Many(select= "selectCourse"))
    })
    List<CourseModel> selectStudent();
      
          
    //Mengembalikan List of Students dari StudentCourse  dengan id_course tertentu
    @Select("select student.npm, name, gpa " + 
    "from student join studentcourse " + 
    "on student.npm = studentcourse.npm "  + 
    "where studentcourse.id_course = #{id_course}")
    List<StudentModel> selectStudents (@Param("id_course") String id_course);
   
}
