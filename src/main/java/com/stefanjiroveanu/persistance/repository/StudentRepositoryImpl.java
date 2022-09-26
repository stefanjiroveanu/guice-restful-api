package com.stefanjiroveanu.persistance.repository;

import com.stefanjiroveanu.persistance.model.Student;
import jakarta.transaction.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class StudentRepositoryImpl implements StudentRepository{
    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student update(String uuid, Student student) {
        Student byUuid = findByUuid(uuid);
        student.setData(byUuid.getData());
        save(student);
        return student;
    }

    @Override
    @Transactional
    public void delete(String uuid) {
        Student byUuid = findByUuid(uuid);
        entityManager.remove(byUuid);
    }

    @Override
    @Transactional
    public Student findByUuid(String uuid) {
        return (Student) entityManager.createQuery("SELECT s from Student s where s.uuid = :uuid")
                .setParameter("uuid", uuid).getSingleResult();
    }
}
