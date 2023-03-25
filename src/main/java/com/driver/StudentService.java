package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
     @Autowired
    StudentRepository studentRepository;
    // For add student
    public void addStudent(Student student){

        studentRepository.addStudent(student);
    }

    // For add teacher
    public void addTeacher(Teacher teacher){

        studentRepository.addTeacher(teacher);
    }

    // For add student teacher pair
    public void addStudentTeacherPair(String student, String teacher){

        studentRepository.studentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name){

        Student student = studentRepository.byStudentName(name);
        return student;
    }

    public Teacher getTeacherByName(String name){

        Teacher teacher = studentRepository.byTeacherName(name);
        return teacher;
    }

    public List<String> getStudentByTeacherName(String name){
        List<String> list = studentRepository.getStudentByTeacher(name);
        return list;
    }

    public List<String> getAllStudent(){
        List<String> allStudentList = studentRepository.getAllStudent();
        return allStudentList;
    }

    public void deleteTeacherByName(String name){
        studentRepository.deleteTeacherByname(name);
    }

    public void deleteAllTeacher(){
        studentRepository.deleteAllTeacher();
    }
}
