package hu.gyaposz.tutorial.simplisticmvc.initializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"hu.gyaposz.tutorial.simplisticmvc.initializer"})
public class WebApplicationConfig implements WebMvcConfigurer {

}
