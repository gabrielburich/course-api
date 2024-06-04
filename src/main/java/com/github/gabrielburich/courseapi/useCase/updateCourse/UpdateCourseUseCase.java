package com.github.gabrielburich.courseapi.useCase.updateCourse;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.dto.CourseDTO;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseUseCase {

    private final CourseRepository repository;

    public UpdateCourseUseCase(final CourseRepository repository) {
        this.repository = repository;
    }

    public Course execute(UUID id, CourseDTO courseDTO) {
        var course = repository.getReferenceById(id);
        if (courseDTO.name() != null && !courseDTO.name().isBlank()) {
            course.setName(courseDTO.name());
        }
        if (courseDTO.category() != null) {
            course.setCategory(courseDTO.category());
        }
        return repository.save(course);
    }

}
