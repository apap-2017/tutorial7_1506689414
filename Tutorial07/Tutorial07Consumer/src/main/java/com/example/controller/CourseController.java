package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	CourseService courseDAO;
    
    @RequestMapping("/course/view/{id_course}")
    public String viewCourse (Model modelcourse,
            @PathVariable(value = "id_course") String id_course)
    {
        CourseModel course = courseDAO.selectCourse(id_course);

        if (course != null) {
            modelcourse.addAttribute ("course", course);
            return "viewcourse";
        } else {
            modelcourse.addAttribute ("id_course", id_course);
            return "not-found";
        }
    }

}
