package com.github.gabrielburich.courseapi.dto;

import com.github.gabrielburich.courseapi.domain.Category;
import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.domain.Status;

public record CourseDTO(String name, Category category) {

    public Course toDomain() {
        return Course.builder()
                .name(name)
                .category(category)
                .active(Status.INACTIVE)
                .build();
    }

}
