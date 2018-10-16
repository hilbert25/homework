package com.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.homework.pojo.Person;
import com.homework.service.PersonService;

@Controller
@RequestMapping("person")
public class PersonController {
	@Autowired
	PersonService personworkService;

	@RequestMapping("person")
	public ModelAndView personIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("person");
		return mav;
	}

	@RequestMapping("student")
	public ModelAndView studentIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student");
		return mav;
	}

	@RequestMapping("addPersonText")
	public ModelAndView addMessage(String personName, String fingerPrint, String fingerPrintHash, String personClass,
			String personText) {
		System.out.println(personName);
		System.out.println(fingerPrint);
		System.out.println(fingerPrintHash);
		Person person = new Person();
		person.setPersonName(personName);
		person.setPersonClass(personClass);
		person.setPersonFingerPrint(fingerPrint);
		person.setPersonFingerPrintHash(fingerPrintHash);
		person.setPersonText(personText);
		personworkService.add(person);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("thank");
		return mav;
	}
}
