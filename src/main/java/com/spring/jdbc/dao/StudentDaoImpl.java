package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;
import lombok.Data;

@Data
public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "insert into student(sid,sname,scity) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getSid(), student.getSname(), student.getScity());
		return r;
	}

	@Override
	public int change(Student student) {
		String query = "update student set sid=?, sname=?, scity=? where sid=? ";
		int r = this.jdbcTemplate.update(query, student.getSid(), student.getSname(), student.getScity(),
				student.getSid());
		return r;
	}

	@Override
	public int deleteStudent(int sid) {
		String query = "delete  from student where sid=? ";
		int r = this.jdbcTemplate.update(query, sid);
		return r;
	}

	@Override
	public Student getStudent(int sid) {
		String query = "select * from student where sid=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, sid);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
//select multiple student
		String query = "select * from student ";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

}
