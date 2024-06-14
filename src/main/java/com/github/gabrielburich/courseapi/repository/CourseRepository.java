package com.github.gabrielburich.courseapi.repository;

import com.github.gabrielburich.courseapi.domain.Course;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM course c WHERE (:name is null or c.name = :name) and (:category is null or c.category = :category)")
    List<Course> listByNameOrCategory(String name, String category);

}
