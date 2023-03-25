package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String, Teacher> teacherDb = new HashMap<>();
    HashMap<String, List<String>> studentTeacherDb = new HashMap<>();
    public void addStudent(Student student){
          String key = student.getName();
          studentDb.put(key, student);
    }

    public void addTeacher(Teacher teacher){
         String key = teacher.getName();
         teacherDb.put(key, teacher);
    }

    public void studentTeacherPair(String student, String teacher){
        if(studentTeacherDb.containsKey(teacher)){
            List<String> list = studentTeacherDb.get(teacher);
            list.add(student);
            studentTeacherDb.put(teacher, list);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(student);
            studentTeacherDb.put(teacher, list);
        }
    }

    public Student byStudentName(String name){
        return studentDb.get(name);
    }

    public Teacher byTeacherName(String name){
        return teacherDb.get(name);
    }
    public List<String> getStudentByTeacher(String teacher){
        return studentTeacherDb.get(teacher);
    }

    public List<String> getAllStudent(){
        List<String> list = new ArrayList<>();
        for(String str : studentDb.keySet()){
            list.add(str);
        }

        return list;
    }

    public void deleteTeacherByname(String name){
        List<String> list = studentTeacherDb.get(name);
        for(String str : list){
            studentDb.remove(str);
        }
        teacherDb.remove(name);
        studentTeacherDb.remove(name);
    }

    public void deleteAllTeacher(){
        for(List<String> list : studentTeacherDb.values()){
            for(String str : list){
                studentDb.remove(str);
            }
            teacherDb.clear();
            studentTeacherDb.clear();
        }
    }
}