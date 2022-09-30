package com.stefanjiroveanu.module;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.stefanjiroveanu.controller.StudentController;
import com.stefanjiroveanu.persistance.repository.StudentRepository;
import com.stefanjiroveanu.persistance.repository.StudentRepositoryImpl;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("student-guice"));
        bind(JPAInitializer.class).asEagerSingleton();
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
        install(new StudentModule());
        bind(StudentController.class);
    }

    @Singleton
    private static class JPAInitializer {
        @Inject
        public JPAInitializer(final PersistService service) {
            service.start();
        }
    }
}
