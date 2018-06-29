package com.gao.eurekaclientdockera.staff.service.impl;

import com.gao.eurekaclientdockera.staff.mapper.StaffMapper;
import com.gao.eurekaclientdockera.staff.service.StaffService;
import com.gao.eurekaclientdockera.staff.vo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> getStaffAll() throws Exception {
        return staffMapper.selectAll();
    }
}
