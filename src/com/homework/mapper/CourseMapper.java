package com.homework.mapper;

import java.util.List;
import com.homework.pojo.Course;

public interface CourseMapper {

	public void update(Course course);

	public List<Course> list();

}