package com.stefanjiroveanu.module;

import com.google.inject.servlet.ServletModule;
import com.stefanjiroveanu.servlet.GuiceServlet;

public class GuiceModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/").with(GuiceServlet.class);
    }
}
