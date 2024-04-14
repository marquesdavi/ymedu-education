package com.api.ymedu.dto.course;

public record CourseDTO(
        String name,
        String description,
        String content,
        String instructor,
        String duration
) {
}
