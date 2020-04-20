package com.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 * 
 */
public class Class implements Serializable {
    private String id;

    private String name;

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    这里的toString不包含students，因为加入后相互关联会导致栈溢出
    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}