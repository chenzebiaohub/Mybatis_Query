package com.demo.test;

import com.demo.dao.ClassMapper;
import com.demo.dao.StudentMapper;
import com.demo.model.Class;
import com.demo.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession();
    }
    //传入一个stu对象。如果对象为空，则根据sql语句索引出全部stu，如果不为空，则找出对应那个stu
    @Test
    @After
    public void testSelectStudents(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student stu = new Student();
        stu.setScore((double) 98);
        List<Student> students = mapper.selectStudents(stu);
        System.out.println("--"+students);
    }
    //根据特性查找
    @Test
    public void testSelectSomeNoStudents(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<String> nos = new ArrayList<String>();
        nos.add("1801010410");
        List<Student> students = mapper.selectSomeNoStudents(nos);
        System.out.println("根据学号查询"+students);
    }
//    测试一对一关联查询
    @Test
    @After
    public void testSelect(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> student = mapper.selectAllStudentsByClassId("1");
        System.out.println("一对一"+student);
}
//   测试一对多关联查询,如果class的tostring方法包含了student就会出现栈溢出。
    @After
    @Test
    public void testCollection(){
        ClassMapper mapper = session.getMapper(ClassMapper.class);
        Class aClass  = mapper.selectByPrimaryKey("1");
        System.out.println("一对多"+aClass+"\n"+aClass.getStudents());
}
    @After
    @Test
    public void testInsert(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId("1000000010");
        student.setName("汕头人");
        student.setScore(1400.0);
        student.setClassId("1");
        int insert = mapper.insert(student);
        System.out.println(insert);
    }

}
