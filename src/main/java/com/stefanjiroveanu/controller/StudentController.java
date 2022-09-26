package com.stefanjiroveanu.controller;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;
import com.stefanjiroveanu.persistance.model.Student;
import com.stefanjiroveanu.service.StudentService;

import javax.inject.Inject;

public class StudentController implements ModelDriven<Student> {

    private Student student;

    private String uuid;

    @Inject
    private StudentService service;

    public HttpHeaders show() {
        student = service.findByUuid(uuid);
        System.out.println("GET \t /user/{id}");
        return new DefaultHttpHeaders("show");
    }

    public HttpHeaders create() {
        student = service.save(student);
        System.out.println("POST \t /user" + student.getUuid());
        return new DefaultHttpHeaders("create");
    }

    @Override
    public Student getModel() {
        return student;
    }
}
