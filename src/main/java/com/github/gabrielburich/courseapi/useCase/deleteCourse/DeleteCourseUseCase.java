package com.github.gabrielburich.courseapi.useCase.deleteCourse;

import com.github.gabrielburich.courseapi.repository.CourseRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseUseCase {

    private final CourseRepository repository;

    public DeleteCourseUseCase(final CourseRepository repository) {
        this.repository = repository;
    }

    public void execute(UUID id) {
        repository.deleteById(id);
    }

}
