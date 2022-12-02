package hu.gyaposz.tutorial.simplistic.contexthierarchy;

import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.WebApplicationConfig;
import hu.gyaposz.tutorial.simplistic.contexthierarchy.application.ServiceContextConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ ServiceContextConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebApplicationConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}