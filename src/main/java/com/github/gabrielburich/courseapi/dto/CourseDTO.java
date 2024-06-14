package com.github.gabrielburich.courseapi.dto;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.domain.Status;

public record CourseDTO(String name, String teacher, String category) {

    public Course toDomain() {
        return Course.builder()
                .name(name)
                .teacher(teacher)
                .category(category)
                .active(Status.INACTIVE)
                .build();
    }

}
