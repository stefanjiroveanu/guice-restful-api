package com.stefanjiroveanu.persistance.repository;

import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.stefanjiroveanu.persistance.model.Student;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class StudentRepositoryImpl implements StudentRepository {
    @Inject
    private Provider<EntityManager> entityManager;

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.get().persist(student);
        entityManager.get().flush();
        return student;
    }

    @Override
    @Transactional
    public Student update(String uuid, Student student) {
        Student byUuid = findByUuid(uuid);
        byUuid.setData(student.getData());
        save(byUuid);
        return byUuid;
    }

    @Override
    @Transactional
    public void delete(String uuid) {
        Student byUuid = findByUuid(uuid);
        entityManager.get().remove(byUuid);
    }

    @Override
    @Transactional
    public Student findByUuid(String uuid) {
        return (Student) entityManager.get().createQuery("SELECT s from Student s where s.uuid = :uuid")
                .setParameter("uuid", uuid).getSingleResult();
    }
}
