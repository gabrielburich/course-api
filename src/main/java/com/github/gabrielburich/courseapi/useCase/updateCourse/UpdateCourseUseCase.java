package com.github.gabrielburich.courseapi.useCase.updateCourse;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.dto.CourseDTO;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import java.util.UUID;

import com.github.gabrielburich.courseapi.useCase.listCourse.GetCourseUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseUseCase {

    private final GetCourseUseCase getCourseUseCase;
    private final CourseRepository repository;

    public UpdateCourseUseCase(
            final GetCourseUseCase getCourseUseCase,
            final CourseRepository repository
    ) {
        this.getCourseUseCase = getCourseUseCase;
        this.repository = repository;
    }

    public Course execute(UUID id, CourseDTO courseDTO) {
        var course = getCourseUseCase.execute(id);
        if (course == null) return null;

        if (courseDTO.name() != null && !courseDTO.name().isBlank()) {
            course.setName(courseDTO.name());
        }
        if (courseDTO.teacher() != null && !courseDTO.teacher().isBlank()) {
            course.setTeacher(courseDTO.teacher());
        }
        if (courseDTO.category() != null && !courseDTO.category().isBlank()) {
            course.setCategory(courseDTO.category());
        }
        return repository.save(course);
    }

}
