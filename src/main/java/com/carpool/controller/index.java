package com.carpool.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin()
public class index {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getEmployees() {
        return "Welcome!";
    }
}