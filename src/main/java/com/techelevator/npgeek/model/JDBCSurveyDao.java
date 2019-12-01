package com.techelevator.npgeek.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.model.interfaces.SurveyDao;

@Component
public class JDBCSurveyDao implements SurveyDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//Tested
	@Override
	public Survey save(Survey survey) {
		
		if (!(survey.getEmail().equals(""))) {
	
		String sqlInsert = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
						  +"VALUES (?, ?, ?, ?) RETURNING surveyid";
		long surveyId = jdbcTemplate.queryForObject(sqlInsert, Long.TYPE, survey.getParkCode(),survey.getEmail(), survey.getState(), survey.getActivityLevel());
		
		survey.setId(surveyId);
		}
		
		return survey;

	}

}
