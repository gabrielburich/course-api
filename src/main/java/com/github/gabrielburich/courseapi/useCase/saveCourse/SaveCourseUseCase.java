package com.github.gabrielburich.courseapi.useCase.saveCourse;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.dto.CourseDTO;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseUseCase {

    private final CourseRepository repository;

    public SaveCourseUseCase(final CourseRepository repository) {
        this.repository = repository;
    }

    public Course execute(CourseDTO courseDTO) {
        var course = courseDTO.toDomain();
        return repository.save(course);
    }
}
