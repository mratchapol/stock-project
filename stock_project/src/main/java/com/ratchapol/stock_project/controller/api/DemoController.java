package com.ratchapol.stock_project.controller.api;

import com.ratchapol.stock_project.util.DateUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class DemoController {
    DateUtils dateToday;
    private SayService sayService;
    
    DemoController(DateUtils dateToday, @Qualifier("cat") SayService sayService){
        this.dateToday = dateToday;
        this.sayService = sayService;
    }
    
    @GetMapping("/")
    public String getToday(){
        return dateToday.toString();
    }
    @GetMapping("/say")
    public String say(){
        return sayService.say();
    }
}

interface SayService{
    String say();
}
@Component
class Cat implements SayService{
    @Override
    public String say() {
        return "meow";
    }
}
@Component
class Dog implements SayService{
    @Override
    public String say() {
        return "wolf";
    }
}