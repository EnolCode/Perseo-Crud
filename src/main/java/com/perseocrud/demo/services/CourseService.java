package com.perseocrud.demo.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.perseocrud.demo.exception.CourseNotFoundException;
import com.perseocrud.demo.models.Course;
import com.perseocrud.demo.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseService implements BaseService<Course> {

    private CourseRepository courseRepository;

    @Override
    @Transactional
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);

    }

    @Override
    @Transactional
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Course courseDeleted = findById(id);
        courseRepository.deleteById(courseDeleted.getId());
    }

    @Transactional
    public Course updatecourse(Long id, Course courseDetails) {
        Course course = findById(id);
        course.setCourseName(courseDetails.getCourseName());
        return save(course);
    }

}
