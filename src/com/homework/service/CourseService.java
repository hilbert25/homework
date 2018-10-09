package com.homework.service;

import java.util.List;

import com.homework.pojo.Course;

public interface CourseService {

	List<Course> list();

	public void update(Course course);
}
