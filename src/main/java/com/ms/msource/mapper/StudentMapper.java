package com.ms.msource.mapper;

import com.ms.msource.entity.Student;
import com.ms.msource.entity.StudentExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insert(Student student);
    List<Student> selectByExample(StudentExample studentExample);
}
