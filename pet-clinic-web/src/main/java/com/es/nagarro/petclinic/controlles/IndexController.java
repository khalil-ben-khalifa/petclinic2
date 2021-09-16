package com.es.nagarro.petclinic.controlles;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }
}
