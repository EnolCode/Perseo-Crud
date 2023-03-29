package com.perseocrud.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.perseocrud.demo.models.Course;
import com.perseocrud.demo.services.CourseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("api/courses")
public class CourseController {
    
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllUsers() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping(value = "add", consumes = "application/json")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updatecourse(id, courseDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
