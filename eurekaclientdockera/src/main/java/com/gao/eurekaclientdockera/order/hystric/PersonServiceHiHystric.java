package com.gao.eurekaclientdockera.order.hystric;


import com.gao.eurekaclientdockera.order.service.PersonServiceHi;
import com.gao.eurekaclientdockera.order.vo.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceHiHystric implements PersonServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public Person sayHiObjFromClientOne(Person p) {
        return new Person(1,"sorry "+p.getName());
    }
}