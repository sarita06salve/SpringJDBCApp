package com.example.telusko.model;

import org.springframework.stereotype.Component;

@Component
public class Language 
{
	private String lang_id;
	private String lang_name;
	
	public String getLang_id() {
		return lang_id;
	}
	public void setLang_id(String lang_id) {
		this.lang_id = lang_id;
	}
	public String getLang_name() {
		return lang_name;
	}
	public void setLang_name(String lang_name) {
		this.lang_name = lang_name;
	}
	
	@Override
	public String toString() {
		return "Language [lang_id=" + lang_id + ", lang_name=" + lang_name + "]";
	}
	
	public Language(String lang_id, String lang_name) {
		super();
		this.lang_id = lang_id;
		this.lang_name = lang_name;
	}
	
	public Language()
	{
		
	}
	
	
}
