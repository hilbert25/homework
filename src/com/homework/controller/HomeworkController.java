package com.homework.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.homework.pojo.Course;
import com.homework.pojo.Homework;
import com.homework.pojo.UploadFile;
import com.homework.service.CourseService;
import com.homework.service.HomeworkService;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("")
public class HomeworkController {
	@Autowired
	HomeworkService homeworkService;
	@Autowired
	CourseService courseService;

	@RequestMapping("")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		List<Course> course = courseService.list();
		int courseIndex = course.get(0).getCourseIndex();
		String courseHomeWork = course.get(0).getCourseHomeWork();
		mav.addObject("courseHomeWork", courseHomeWork);
		mav.addObject("courseIndex", courseIndex);
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("search")
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("search");
		return mav;
	}

	@RequestMapping(value = "test", method = RequestMethod.POST)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		// fingerPrint = request.getParameter("fingerPrint");
		// System.out.println(request + " " + request.getParameter("fingerPrint"));
	}

	@RequestMapping("front")
	public ModelAndView front() {
		ModelAndView mav = new ModelAndView();
		List<Course> courseList = courseService.list();
		mav.addObject("courseHomeWork", courseList.get(0).getCourseHomeWork());
		mav.addObject("courseIndex", courseList.get(0).getCourseIndex());
		mav.setViewName("front");
		return mav;
	}

	@RequestMapping("searchMyHomeWork")
	public ModelAndView searchMyHomeWork(String stuId, String stuName) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, String> map = new HashMap<>();
		map.put("stuId", stuId);
		map.put("stuName", stuName);
		List<Homework> cs = homeworkService.searchMyHomeWork(map);
		mav.addObject("cs", cs);
		mav.setViewName("search");
		return mav;
	}

	@RequestMapping("searchAllHomeWorkByIndex")
	public ModelAndView searchAllHomeWorkByIndex(int homeWorkIndex) {
		System.out.println(homeWorkIndex);
		ModelAndView mav = new ModelAndView();
		List<Homework> cs = homeworkService.searchAllHomeWorkByIndex(homeWorkIndex);
		mav.addObject("cs", cs);
		List<Course> courseList = courseService.list();
		mav.addObject("courseHomeWork", courseList.get(0).getCourseHomeWork());
		mav.addObject("courseIndex", courseList.get(0).getCourseIndex());
		mav.setViewName("front");
		return mav;
	}

	@RequestMapping("updateHomeWork")
	public ModelAndView updateHomeWork(String courseIndex, String courseHomeWork) {
		Course course = new Course();
		course.setCourseIndex(Integer.valueOf(courseIndex));
		course.setCourseHomeWork(courseHomeWork);
		ModelAndView mav = new ModelAndView();
		courseService.update(course);
		List<Course> courseList = courseService.list();
		mav.addObject("courseHomeWork", courseList.get(0).getCourseHomeWork());
		mav.addObject("courseIndex", courseList.get(0).getCourseIndex());
		mav.setViewName("front");
		return mav;
	}

	@RequestMapping("uploadFile")
	public ModelAndView upload(HttpServletRequest request, UploadFile file, String stuId, String stuName,
			String fingerPrint, String fingerPrintHash) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		if (stuId.length() == 0 || stuName.length() == 0) {
			List<Course> courseList = courseService.list();
			mav.addObject("courseHomeWork", courseList.get(0).getCourseHomeWork());
			mav.addObject("courseIndex", courseList.get(0).getCourseIndex());
			mav.setViewName("index");
			return mav;
		}
		List<Course> course = courseService.list();
		int courseIndex = course.get(0).getCourseIndex();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String name = String.valueOf(stuId) + "-" + stuName + "-第" + String.valueOf(courseIndex) + "次作业 -"
				+ String.valueOf(new Date().getTime());
		String newFileName = name + file.getFileType();
		File newFile = new File("/root/work/homework-" + String.valueOf(courseIndex) + "/", newFileName);
		Homework homework = new Homework();
		homework.setStuId(stuId);
		homework.setStuName(stuName);
		homework.setHomeWorkTitle(name);
		homework.setHomeWorkPath(newFile.getAbsolutePath());
		homework.setHomeWorkIndex(courseIndex);
		homework.setHomeWorkSubmitTime(df.format(new Date()));
		homework.setFingerPrint(fingerPrint);
		homework.setFingerPrintHash(fingerPrintHash);
		homeworkService.add(homework);
		newFile.getParentFile().mkdirs();
		file.getFile().transferTo(newFile);
		HashMap<String, String> map = new HashMap<>();
		map.put("stuId", stuId);
		map.put("stuName", stuName);
		List<Homework> cs = homeworkService.searchMyHomeWork(map);
		mav.addObject("cs", cs);
		mav.setViewName("search");
		return mav;
	}

}
