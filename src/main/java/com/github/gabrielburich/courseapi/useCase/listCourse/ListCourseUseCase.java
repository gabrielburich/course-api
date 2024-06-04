package com.github.gabrielburich.courseapi.useCase.listCourse;

import com.github.gabrielburich.courseapi.domain.Category;
import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.repository.CourseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListCourseUseCase {

    private final CourseRepository repository;

    public ListCourseUseCase(final CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> execute(String name, String category) {
        var categoryEnum = category != null ? Category.valueOf(category) : null;
        return repository.listByNameOrCategory(name, categoryEnum);
    }

}
