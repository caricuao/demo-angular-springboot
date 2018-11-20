package com.prueba.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HelloWorldController {
   
    
   @RequestMapping("/hello")
   @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
   public String sayHello() {
      return "Hello Spring Boot!!";
   }
}
