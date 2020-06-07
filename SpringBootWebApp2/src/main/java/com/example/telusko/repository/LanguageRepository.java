package com.example.telusko.repository;

import com.example.telusko.model.Language;
import java.util.*;

public interface LanguageRepository 
{
	public int insertLanguage(Language language);
	
	public int updateLanhguage(Language language);
	
	public int deleteLanguage(Language language);
	
	public List<Language> getLangData();
}
