package com.gao.eurekaclientdockerb.staff.service.impl;

import com.gao.eurekaclientdockerb.staff.mapper.StaffMapper;
import com.gao.eurekaclientdockerb.staff.service.StaffService;
import com.gao.eurekaclientdockerb.staff.vo.Staff;
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
