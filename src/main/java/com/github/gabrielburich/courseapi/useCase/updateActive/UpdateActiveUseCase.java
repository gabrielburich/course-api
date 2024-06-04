package com.github.gabrielburich.courseapi.useCase.updateActive;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateActiveUseCase {

    private final CourseRepository repository;

    public UpdateActiveUseCase(final CourseRepository repository) {
        this.repository = repository;
    }

    public Course execute(UUID id) {
        var course = repository.getReferenceById(id);
        course.toggleActive();
        return repository.save(course);
    }

}
