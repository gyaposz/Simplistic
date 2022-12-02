package hu.gyaposz.tutorial.simplistic.contexthierarchy.web;

import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.util.ViewBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("hu.gyaposz.tutorial.simplistic.contexthierarchy.web")
public class WebApplicationConfig implements WebMvcConfigurer {

    @Bean
    ViewBean viewBean() {
        return new ViewBean();
    }
}
