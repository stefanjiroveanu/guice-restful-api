package com.stefanjiroveanu.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.stefanjiroveanu.module.GuiceModule;

import javax.servlet.annotation.WebListener;

@WebListener
public class ServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new GuiceModule());
    }
}