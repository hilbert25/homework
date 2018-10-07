package com.homework.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.mapper.HomeworkMapper;
import com.homework.pojo.Homework;
import com.homework.service.HomeworkService;

@Service
public class HomeworkServiceImpl implements HomeworkService {
	@Autowired
	HomeworkMapper homeworkMapper;

	public List<Homework> list() {
		return homeworkMapper.list();
	}

	@Override
	public void add(Homework homework) {
		// TODO Auto-generated method stub
		homeworkMapper.add(homework);
	}

	@Override
	public List<Homework> searchMyHomeWork(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return homeworkMapper.searchMyHomeWork(map);
	};

}
