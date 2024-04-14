package com.api.ymedu.controller;

import com.api.ymedu.dto.course.CourseDTO;

import com.api.ymedu.service.CourseService;
import jakarta.validation.Valid;
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

    @GetMapping()
    public ResponseEntity<?> listCourses(){
        return service.listCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable UUID id){
        return service.getCourseById(id);
    }

    @PostMapping()
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDto){
        return service.createCourse(courseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity updateCourse(
            @PathVariable UUID id,
            @Valid @RequestBody CourseDTO courseDTO){
        return service.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(
            @PathVariable UUID id){
        return service.deleteCourse(id);
    }
}
