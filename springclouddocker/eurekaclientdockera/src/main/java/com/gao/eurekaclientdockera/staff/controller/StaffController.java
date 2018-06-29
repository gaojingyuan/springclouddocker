package com.gao.eurekaclientdockera.staff.controller;

import com.gao.eurekaclientdockera.staff.service.StaffService;
import com.gao.eurekaclientdockera.staff.vo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/getStaffAll",method = RequestMethod.GET)
    public String getStaffAll() throws Exception{
        List<Staff> list = staffService.getStaffAll();
        return String.valueOf(list.size());
    }
}

