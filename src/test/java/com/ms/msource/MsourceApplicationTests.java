package com.ms.msource;

import com.ms.msource.entity.Student;
import com.ms.msource.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsourceApplicationTests {
    @Autowired
    private StudentService studentService;

    @Test
    public void testWrite() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(15);
        studentService.insert(student);
    }

    @Test
    public void testRead() {
        for (int i = 0; i < 4; i++) {
            studentService.selectAll();
        }
    }

    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("wangwu");
        student.setAge(18);
        studentService.save(student);
    }

    @Test
    public void testReadFromMaster() {
        studentService.getToken("1234");
    }

}
