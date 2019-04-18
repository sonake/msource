package com.ms.msource.service.impl;

import com.ms.msource.config.Master;
import com.ms.msource.entity.Student;
import com.ms.msource.entity.StudentExample;
import com.ms.msource.mapper.StudentMapper;
import com.ms.msource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Master
    @Override
    public int save(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectByExample(new StudentExample());
    }

    @Master
    @Override
    public String getToken(String appId) {
        return null;
    }
}
