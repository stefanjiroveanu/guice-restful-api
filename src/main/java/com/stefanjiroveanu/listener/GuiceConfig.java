package com.stefanjiroveanu.listener;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.stefanjiroveanu.module.GuiceModule;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public class GuiceConfig extends GuiceResteasyBootstrapServletContextListener {

    @Override
    protected void withInjector(Injector injector) {
        injector.getInstance(PersistService.class);
    }

    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }
}
