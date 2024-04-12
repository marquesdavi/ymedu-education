package com.api.ymedu.service;

import com.api.ymedu.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private ICourseRepository repository;

    @Autowired
    public CourseService (ICourseRepository repository){
        this.repository = repository;
    }
    public ResponseEntity createCourse(){
        return ResponseEntity.ok("Course registered successfully!");
    }

    public ResponseEntity updateCourse(){
        return ResponseEntity.ok("Course updated successfully!");
    }

    public ResponseEntity deleteCourse(){
        return ResponseEntity.ok("Course deleted successfully!");
    }

    public ResponseEntity getCourseById(Integer id){
        return ResponseEntity.ok("Course deleted successfully!");
    }

    public ResponseEntity listCourses(Integer id){
        return ResponseEntity.ok("Course deleted successfully!");
    }
}
