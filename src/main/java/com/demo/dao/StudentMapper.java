package com.demo.dao;

import com.demo.model.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectStudents(Student student);

    List<Student> selectSomeNoStudents(List<String> nos);

    List<Student> selectAllStudentsByClassId(String id);
}