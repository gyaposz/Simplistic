package hu.gyaposz.tutorial.simplistic.contexthierarchy.application.service;

import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.util.ViewBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommonService {

    private final ViewBean viewBean;

    public CommonService(@Autowired(required = false) ViewBean viewBean) {
        // Changing required settings to true will cause NoSuchBeanDefinitionException during WAR deployment.
        // That Bean is only available in the child/servlet context
        this.viewBean = viewBean;
    }
    public String convert(Long value) {
        return Optional.ofNullable(viewBean)
                .map(ViewBean::getContent)
                .orElse(String.valueOf(value));
    }
}
