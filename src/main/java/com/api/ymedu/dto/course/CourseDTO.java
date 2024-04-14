package com.api.ymedu.dto.course;

//Essa classe deve ser utilizada como objeto de entrada e saída dos endpoints
public record CourseDTO(String name, String description, String content, String instructor, String duration)  {
}
