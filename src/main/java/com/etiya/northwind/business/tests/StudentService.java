package com.etiya.northwind.business.tests;

import com.etiya.northwind.core.utilities.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<Student>();
    public StudentService() {
        students.add(new Student(1,"Burcu"));
        students.add(new Student(2,"Engin"));
        students.add(new Student(3,"Sehl"));
        students.add(new Student(4,"Elif"));
        students.add(new Student(5,"Mert"));
    }

    public void add(Student student) {

        checkIfStudentNameExists(student);
        students.add(student);


    }

    public int size() {
        return students.size();
    }
    private void checkIfStudentNameExists(Student student) {
        for (Student currentStudent : students) {
            if(currentStudent.getName()==student.getName()) {
                throw new BusinessException("Bu ogrenci zaten mevcut");
            }
        }
    }
}
