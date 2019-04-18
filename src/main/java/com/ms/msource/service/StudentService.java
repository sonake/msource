package com.ms.msource.service;

import com.ms.msource.config.Master;
import com.ms.msource.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentService {
    @Transactional
    public int insert(Student student);

    @Master
    public int save(Student student);

    public List<Student> selectAll();

    @Master
    public String getToken(String appId);
}
