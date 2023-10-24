package com.luv2code.curddemo.dao;

import com.luv2code.curddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
