package com.gao.eurekaclientdockera.order.controller;


import com.gao.eurekaclientdockera.order.service.PersonServiceHi;
import com.gao.eurekaclientdockera.order.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {

    @Autowired
    private PersonServiceHi personServiceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return personServiceHi.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/hiObj")
    public Person sayHiObj(@RequestBody Person p){
        final Person person = personServiceHi.sayHiObjFromClientOne(p);
        return person;
    }
}
