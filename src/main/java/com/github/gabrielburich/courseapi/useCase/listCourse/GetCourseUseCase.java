package com.github.gabrielburich.courseapi.useCase.listCourse;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCourseUseCase {

    private final CourseRepository repository;

    public GetCourseUseCase(final CourseRepository repository) {
        this.repository = repository;
    }

    public Course execute(UUID id) {
        return repository.findById(id).orElse(null);
    }

}
