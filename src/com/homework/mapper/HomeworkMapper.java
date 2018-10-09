package com.homework.mapper;

import java.util.HashMap;
import java.util.List;

import com.homework.pojo.Homework;

public interface HomeworkMapper {

	public int add(Homework homework);

	public void delete(int id);

	public Homework get(int id);

	public int update(Homework homework);

	public List<Homework> list();

	public int count();

	public List<Homework> searchMyHomeWork(HashMap<String, String> map);

	public List<Homework> searchAllHomeWorkByIndex(int homeWorkIndex);

}