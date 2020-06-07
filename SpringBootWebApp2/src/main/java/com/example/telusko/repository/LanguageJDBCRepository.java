package com.example.telusko.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.example.telusko.model.Language;

@Repository
public class LanguageJDBCRepository implements LanguageRepository
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insertLanguage(Language language)
	{
		try
		{
			String sql = "insert into language (lang_id,lang_name) values (?,?)";
			int i = jdbcTemplate.update(sql, 
					new Object[] {
					language.getLang_id(),
					language.getLang_name()
					});
			System.out.println("In insertLanguage :::" +i);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLanhguage(Language language) 
	{
		String sql = "";
		int i = 0;
		try
		{
			sql = "update "
				+ "Language "
				+ "set "
				+ "lang_name = ? "
				+ "where "
				+ "lang_id = ?";
			
			i = jdbcTemplate.update(sql, 
					new Object[] {
				    language.getLang_name(),
				    language.getLang_id()
					});
			System.out.println("In updateLanguage :::" +i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLanguage(Language language) 
	{
		String sql = "";
		int i = 0;
		try
		{
			sql = "delete "
					+ "from "
					+ "Language "
					+ "where "
					+ "lang_id = ?";
			
			i =  jdbcTemplate.update(sql, 
					new Object[] {
							language.getLang_id()
			});
			System.out.println("In deleteLanguage :::" +i);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Language> getLangData() 
	{
		List<Language> myList = new ArrayList<>();
		try
		{
			String sql = "Select * from Language";
			myList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Language.class));
			
			for(Language language : myList)
			{
				System.out.println("**" + language.getLang_id() + "\t" + language.getLang_name());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return myList;
	}
}
