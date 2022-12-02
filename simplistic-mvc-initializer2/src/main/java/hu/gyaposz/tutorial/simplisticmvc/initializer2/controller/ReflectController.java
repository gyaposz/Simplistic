package hu.gyaposz.tutorial.simplisticmvc.initializer2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ReflectController
{
    @GetMapping("/{value}")
    public String getValue(@PathVariable Long value)
    {
        return String.valueOf(value);
    }
}
