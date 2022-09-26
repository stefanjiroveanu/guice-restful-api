package com.stefanjiroveanu.module;

import com.google.inject.AbstractModule;
import com.stefanjiroveanu.persistance.repository.StudentRepository;
import com.stefanjiroveanu.persistance.repository.StudentRepositoryImpl;

public class StudentModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
    }
}
