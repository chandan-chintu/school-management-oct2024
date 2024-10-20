package com.simpleproejct.school_management.controller;

import com.simpleproejct.school_management.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    // here we are using hashmap for database operation(CRUD)
    HashMap<Integer, Student> studentDB = new HashMap<>();

//    1->{1,abc,"15/10/2023",......}
//    2->{2,abc,"15/10/2023",......}
//    3->{3,abc,"15/10/2023",......}

    // @RequestBody - takes input or request from ui/postman and assigns it to object
    @PostMapping("/save")
    public String saveStudent(@RequestBody Student studentRequest){
        // take studentRequest and add it inside hashmap
        studentDB.put(studentRequest.getStudentId(), studentRequest);
        return "Student added successfully";
    }

    @GetMapping("/findAll")
    public HashMap<Integer, Student> getAllStudents(){
        return studentDB;
    }

    // @PathVariable - input is sent in the url path(endpoint)
    @GetMapping("/find/{studentid}")
    public Student getStudentById(@PathVariable("studentid") int studentId){
        Student student = studentDB.get(studentId);
        return student;
    }

    //@RequestParam - it takes the input in the form of a request parameter as a query
    @GetMapping("/findByName")
    public Student getStudentByName(@RequestParam("name") String name){
        for(Student student : studentDB.values()){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    @GetMapping("/findByGrade")
    public List<Student> getStudentByGrade(@RequestParam("grade") String grade){
        List<Student> studentList = new ArrayList<>();
        for(Student student : studentDB.values()){
            if(student.getGrade().equals(grade)){
                studentList.add(student);
            }
        }
        return studentList;
    }

    @GetMapping("/findByNameAndGrade")
    public List<Student> getStudentByNameAndGrade(@RequestParam("name") String name, @RequestParam("grade") String grade){
        List<Student> studentList = new ArrayList<>();
        for(Student student : studentDB.values()){
            if(student.getName().equals(name) && student.getGrade().equals(grade)){
                studentList.add(student);
            }
        }
        return studentList;
    }
}
