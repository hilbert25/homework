package com.homework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homework.mapper.CourseMapper;
import com.homework.pojo.Course;
import com.homework.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseMapper courseMapper;

	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		return courseMapper.list();
	}

	@Override
	public void update(Course course) {
		// TODO Auto-generated method stub
		courseMapper.update(course);
	}

}
