package hu.gyaponyi.tutorial.simpleMVC.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class FirstController
{
    @GetMapping("/{id}")
    public String getPerson(@PathVariable Long id)
    {
        return String.valueOf(id);
    }
}
