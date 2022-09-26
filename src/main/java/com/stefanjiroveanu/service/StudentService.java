package com.stefanjiroveanu.service;

import com.stefanjiroveanu.persistance.model.Student;
import com.stefanjiroveanu.persistance.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student update(String uuid, Student student) {
        return studentRepository.update(uuid, student);
    }

    public void delete(String uuid) {
        studentRepository.delete(uuid);
    }

    public Student findByUuid(String uuid) {
        return studentRepository.findByUuid(uuid);
    }
}
