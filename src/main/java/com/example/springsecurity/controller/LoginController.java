package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sam
 * @create 2021-08-28 17:01
 */
@Controller
public class LoginController {

    @RequestMapping({"/","/index"})
    public String getindex(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String getLogin(){
        return "views/login";
    }
    @RequestMapping("/level1/{id}")
    public String getLevel1(@PathVariable("id")int id){
        return "views/level1/"+id;
    }
    @RequestMapping("/level2/{id}")
    public String getLevel2(@PathVariable("id")int id){
        return "views/level2/"+id;
    }
    @RequestMapping("/level3/{id}")
    public String getLevel3(@PathVariable("id")int id){
        return "views/level3/"+id;
    }

}
