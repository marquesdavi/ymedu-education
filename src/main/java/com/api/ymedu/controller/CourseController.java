package com.api.ymedu.controller;

import com.api.ymedu.dto.course.CourseDTO;
import com.api.ymedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService service;

    @Autowired
    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> listCourses(){
        return service.listCourses();
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDto){
        return service.createCourse(courseDto);
    }

}
