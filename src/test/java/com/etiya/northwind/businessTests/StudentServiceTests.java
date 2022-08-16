package com.etiya.northwind.businessTests;

import com.etiya.northwind.business.tests.Student;
import com.etiya.northwind.business.tests.StudentService;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class StudentServiceTests {
    StudentService studentService;
    @BeforeEach
    public void setup() {
        studentService = new StudentService();
    }

    @Test
    public void students_size_should_increase_one_when_added() {

        //arrange //given
        Student student = new Student(6,"Burcu");
        int studentSize = this.studentService.size();
        int expected = studentSize +1;

        //act //when
        this.studentService.add(student);
        int actual = this.studentService.size();

        //assert //then
        Assertions.assertEquals(expected,actual);
    }



    @Test public void student_name_can_not_be_duplicated_when_added() {
        Student student = new Student(7,"Engin");

        Executable executable = ()->this.studentService.add(student);

        Assertions.assertThrows(BusinessException.class, executable);
    }

}
