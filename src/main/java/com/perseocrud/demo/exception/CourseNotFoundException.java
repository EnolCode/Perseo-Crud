package com.perseocrud.demo.exception;

public class CourseNotFoundException  extends RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
