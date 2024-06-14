package com.github.gabrielburich.courseapi.useCase.updateActive;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import java.util.UUID;

import com.github.gabrielburich.courseapi.useCase.listCourse.GetCourseUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateActiveUseCase {

    private final GetCourseUseCase getCourseUseCase;
    private final CourseRepository repository;

    public UpdateActiveUseCase(
            final GetCourseUseCase getCourseUseCase,
            final CourseRepository repository
    ) {
        this.getCourseUseCase = getCourseUseCase;
        this.repository = repository;
    }

    public Course execute(UUID id) {
        var course = getCourseUseCase.execute(id);
        if (course == null) return null;

        course.toggleActive();
        return repository.save(course);
    }

}
