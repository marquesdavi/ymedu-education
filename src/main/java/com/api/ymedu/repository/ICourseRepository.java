package com.api.ymedu.repository;

import com.api.ymedu.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICourseRepository extends JpaRepository<Course, UUID> {
    Course findCourseById(UUID id);

    @Override
    void deleteById(UUID id);
}
