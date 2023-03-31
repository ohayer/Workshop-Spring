package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class Homepage {
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String homepage(){
        return "home";
    }
}
