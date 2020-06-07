package com.example.telusko.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.telusko.model.Language;
import com.example.telusko.repository.LanguageJDBCRepository;


@Controller
public class IndexController 
{
	@Autowired
	private LanguageJDBCRepository languageJDBCRepository;
	
	@Autowired
	private Language language;
	
	@RequestMapping("index")
	public String read()
	{
		return "index";
	}
	
	
	@RequestMapping(value = "/showdata" , method = RequestMethod.POST)
	public ModelAndView showData(@RequestParam("lang_id") String lang_id , @RequestParam("lang_name") String lang_name)
	{	
		System.out.println("Inside show.data");

		language.setLang_id(lang_id);
		language.setLang_name(lang_name);
		languageJDBCRepository.insertLanguage(language);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("language", lang_name);
		mv.setViewName("updateLanguage");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/updatedata", method = RequestMethod.POST)
	public ModelAndView updateData(@RequestParam("lang_id") String lang_id , @RequestParam("lang_name") String lang_name)
	{
		ModelAndView mv = new ModelAndView();
		try
		{
			System.out.println("Inside UpdateData method!!!!!!!!!!!!");
			
			language.setLang_id(lang_id);
			language.setLang_name(lang_name);
			languageJDBCRepository.updateLanhguage(language);
			
			mv.setViewName("deletedata");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/deletedata" , method = RequestMethod.POST)
	public ModelAndView deleteLanguage(@RequestParam("lang_id") String lang_id)
	{
		ModelAndView mv = new ModelAndView();
		try
		{
           System.out.println("Inside deletedata method!!!!!!!!!!!!");
			
			language.setLang_id(lang_id);
			languageJDBCRepository.deleteLanguage(language);
			
			mv.setViewName("index");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/showinfo" , method = RequestMethod.POST)
	public ModelAndView showLanguage()
	{
		ModelAndView mv = new ModelAndView();
		List<Language> langList = new ArrayList<>();
		try
		{
			langList = languageJDBCRepository.getLangData();
			mv.addObject("languageList", langList);
			mv.setViewName("show");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return mv;
	}
}
