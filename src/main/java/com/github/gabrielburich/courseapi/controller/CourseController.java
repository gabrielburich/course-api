package com.github.gabrielburich.courseapi.controller;

import com.github.gabrielburich.courseapi.domain.Course;
import com.github.gabrielburich.courseapi.dto.CourseDTO;
import com.github.gabrielburich.courseapi.useCase.deleteCourse.DeleteCourseUseCase;
import com.github.gabrielburich.courseapi.useCase.listCourse.ListCourseUseCase;
import com.github.gabrielburich.courseapi.useCase.saveCourse.SaveCourseUseCase;
import com.github.gabrielburich.courseapi.useCase.updateActive.UpdateActiveUseCase;
import com.github.gabrielburich.courseapi.useCase.updateCourse.UpdateCourseUseCase;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final SaveCourseUseCase saveCourseUseCase;
    private final ListCourseUseCase listCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final UpdateActiveUseCase updateActiveUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;

    public CourseController(
            final SaveCourseUseCase saveCourseUseCase,
            final ListCourseUseCase listCourseUseCase,
            final UpdateCourseUseCase updateCourseUseCase,
            final UpdateActiveUseCase updateActiveUseCase,
            final DeleteCourseUseCase deleteCourseUseCase
    ) {
        this.saveCourseUseCase = saveCourseUseCase;
        this.listCourseUseCase = listCourseUseCase;
        this.updateCourseUseCase = updateCourseUseCase;
        this.updateActiveUseCase = updateActiveUseCase;
        this.deleteCourseUseCase = deleteCourseUseCase;
    }

    @PostMapping
    public ResponseEntity<Course> save(@Valid @RequestBody CourseDTO courseDTO) {
        var result = saveCourseUseCase.execute(courseDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Course>> list(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "category", required = false) String category
    ) {
        var result = listCourseUseCase.execute(name, category);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable String id, @Valid @RequestBody CourseDTO courseDTO) {
        var result = updateCourseUseCase.execute(UUID.fromString(id), courseDTO);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Course> patch(@PathVariable String id) {
        var result = updateActiveUseCase.execute(UUID.fromString(id));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> delete(@PathVariable String id) {
        deleteCourseUseCase.execute(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
