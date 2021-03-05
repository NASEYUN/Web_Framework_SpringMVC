package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSouce(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 학년/학기별 이수 총 학점
	public List<Offer> getGrade() {
		String sqlStatement = "select year, semester, sum(grade) from course group by year, semester"; // placeholder

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setGrade(rs.getInt("sum(grade)"));

				return offer;
			}
		});
	}

	// 링크 클릭시
	public List<Offer> getOffer(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?"; // placeholder

		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setSubjectcode(rs.getString("subjectcode"));
				offer.setSubject(rs.getString("subject"));
				offer.setDivision(rs.getString("division"));
				offer.setGrade(rs.getInt("grade"));

				return offer;
			}

		});
	}

	// 수강신청내역조회
	public List<Offer> getOffers() {
		String sqlStatement = "select * from course where year=? and semester=?"; // placeholder

		return jdbcTemplate.query(sqlStatement, new Object[] { 2020, 1 }, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setSubjectcode(rs.getString("subjectcode"));
				offer.setSubject(rs.getString("subject"));
				offer.setDivision(rs.getString("division"));
				offer.setGrade(rs.getInt("grade"));

				return offer;
			}

		});
	}

	// DB에저장
	public boolean insert(Offer offer) {
		int year = 2020;
		int semester = 1;
		String subjectcode = offer.getSubjectcode();
		String subject = offer.getSubject();
		String division = offer.getDivision();
		int grade = offer.getGrade();

		String sqlStatement = "insert into course (year, semester, subjectcode, subject, division, grade) values (?, ?, ?, ?, ?, ?)";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, subjectcode, subject, division, grade }) == 1);
	}

	public boolean update(Offer offer) {
		int id = offer.getId();
		int year = offer.getYear();
		int semester = offer.getSemester();
		String subjectcode = offer.getSubjectcode();
		String subject = offer.getSubject();
		String division = offer.getDivision();
		int grade = offer.getGrade();

		String sqlStatement = "update course set year=?, semester=?, subjectcode=? subject=?, division=? grade=?where id=?";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, subjectcode, subject, division, grade, id }) == 1);
	}

	public boolean delete(int id) {
		String sqlStatement = "delete from course where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
	}
}
