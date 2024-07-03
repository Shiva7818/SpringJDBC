package com.spring.jdbc.dao;



import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	public void createDatabase()
	{
		this.jdbcTemplate.update("create database spring;");
	}
	public void createTable(String query)
	{
		 this.jdbcTemplate.update(query);
		
	}
	@Override
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?);";
		
		int res = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return res;
	}
	public int update(Student student)
	{
//		String query = "update student set name=? , city=? where id=5";
//		int res = this.jdbcTemplate.update(query,student.getName(),student.getCity());
		String query = "update student set name=? , city=? where id=?";
		int res = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	}
	public int delete(int studentId)
	{
		String query = "delete from student where id=?";
		int res = this.jdbcTemplate.update(query,studentId);
		return res;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Student getStudent(int studentId) {
		String query = "SELECT * FROM student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}
	@Override
	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> students = jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}

}
