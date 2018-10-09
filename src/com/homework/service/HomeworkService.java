package com.homework.service;

import java.util.HashMap;
import java.util.List;

import com.homework.pojo.Homework;

public interface HomeworkService {

	List<Homework> list();

	void add(Homework homework);

	List<Homework> searchMyHomeWork(HashMap<String, String> map);

	List<Homework> searchAllHomeWorkByIndex(int homeWorkIndex);
}
