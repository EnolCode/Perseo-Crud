package com.perseocrud.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perseocrud.demo.models.Course;

public interface CourseRepository  extends JpaRepository <Course, Long> {
    
}
