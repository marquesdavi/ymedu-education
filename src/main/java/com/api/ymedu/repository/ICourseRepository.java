package com.api.ymedu.repository;

import com.api.ymedu.model.course.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICourseRepository extends JpaRepository<Course, UUID> {
    Course findCourseById(UUID id);

    @Override
    void deleteById(UUID id);

    @Transactional
    void deleteByName(String Name);

    Course findCourseByName(String name);
}
