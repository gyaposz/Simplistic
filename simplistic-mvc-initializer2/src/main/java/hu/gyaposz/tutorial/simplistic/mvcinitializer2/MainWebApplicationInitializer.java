package hu.gyaposz.tutorial.simplistic.mvcinitializer2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(final ServletContext sc) {

        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

        root.scan("hu.gyaposz.tutorial.simplistic.mvcinitializer2");
        sc.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appServlet = sc.addServlet("SpringMVC", new DispatcherServlet(root));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}
