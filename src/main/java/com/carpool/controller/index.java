package com.carpool.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.exceptionHandler.GeneralException;
@RestController
@CrossOrigin()
public class index {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getEmployees() {
    	//throw new GeneralException("test",HttpStatus.NOT_FOUND));
        return "Welcome!";
        
        
    }
}