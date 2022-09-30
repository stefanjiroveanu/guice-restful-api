package com.stefanjiroveanu.persistance.repository;

import com.stefanjiroveanu.persistance.model.Student;

public interface StudentRepository {
    Student save(Student student);

    Student update(String uuid, Student student);

    void delete(String uuid);

    Student findByUuid(String uuid);
}
