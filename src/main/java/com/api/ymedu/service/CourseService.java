package com.api.ymedu.service;

import com.api.ymedu.dto.course.CourseDTO;
import com.api.ymedu.model.course.Course;
import com.api.ymedu.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

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

    @Transactional
    public ResponseEntity updateCourse(UUID id, CourseDTO courseDTO){
        try{
            Course course = repository.findById(id).get();

            course.setName(courseDTO.name());
            course.setDescription(courseDTO.description());
            course.setInstructor(courseDTO.instructor());
            course.setDuration(courseDTO.duration());
            course.setContent(courseDTO.content());

            return new ResponseEntity(repository.save(course), HttpStatus.OK);

        } catch (NoSuchElementException ex){
            return new ResponseEntity("Course not found, please, try again!", HttpStatus.NOT_FOUND);
        }
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
