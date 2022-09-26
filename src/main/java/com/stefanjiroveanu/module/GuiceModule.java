package com.stefanjiroveanu.module;

import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import java.util.Properties;

public class GuiceModule extends ServletModule {

    @Override
    protected void configureServlets() {
        //basically filter every request trough struts 2
        bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class);
        filter("/*").through(StrutsPrepareAndExecuteFilter.class);
        install(new JpaPersistModule("studentdb").properties(jpaProperties()));
        filter("/*").through(PersistFilter.class);
        install(new StudentModule());
    }

    private Properties jpaProperties() {

        Properties properties = new Properties();

        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.pool_size", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.cache.use.query_cache", "true");
        properties.put("hibernate.cache.use_second_level_cache", "true");

        return properties;
    }
}
