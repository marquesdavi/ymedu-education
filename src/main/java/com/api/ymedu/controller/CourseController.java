package com.api.ymedu.controller;

import com.api.ymedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService service;

    @Autowired
    public CourseController(CourseService service){
        this.service = service;
    }
}
