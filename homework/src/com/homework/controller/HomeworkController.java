package com.homework.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homework.pojo.Homework;
import com.homework.pojo.UploadFile;
import com.homework.service.HomeworkService;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("")
public class HomeworkController {
	@Autowired
	HomeworkService homeworkService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory() {
		ModelAndView mav = new ModelAndView();
		List<Homework> cs = homeworkService.list();
		mav.addObject("cs", cs);
		mav.setViewName("listCategory");
		return mav;
	}

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("search")
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("search");
		return mav;
	}

	@RequestMapping("searchMyHomeWork")
	public ModelAndView searchMyHomeWork(String stuId, String stuName) {
		System.out.println(stuId+" "+stuName);
		ModelAndView mav = new ModelAndView();
		HashMap<String, String> map = new HashMap<>();
		map.put("stuId", stuId);
		map.put("stuName", stuName);
		List<Homework> cs = homeworkService.searchMyHomeWork(map);
		mav.addObject("cs", cs);
		mav.setViewName("search");
		return mav;
	}

	@RequestMapping("/uploadFile")
	public ModelAndView upload(HttpServletRequest request, UploadFile file, String stuId, String stuName)
			throws IllegalStateException, IOException {
		int homeWorkIndex = 2;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String name = String.valueOf(stuId) + "-" + stuName + " 第" + String.valueOf(homeWorkIndex) + "次作业 -"
				+ String.valueOf(new Date().getTime());
		String newFileName = name + file.getFileType();
		File newFile = new File("D:/image/", newFileName);
		Homework homework = new Homework();
		homework.setStuId(stuId);
		homework.setStuName(stuName);
		homework.setHomeWorkTitle(name);
		homework.setHomeWorkPath(newFile.getAbsolutePath());
		homework.setHomeWorkIndex(homeWorkIndex);
		homework.setHomeWorkSubmitTime(df.format(new Date()));
		homeworkService.add(homework);
		newFile.getParentFile().mkdirs();
		file.getFile().transferTo(newFile);
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

}
