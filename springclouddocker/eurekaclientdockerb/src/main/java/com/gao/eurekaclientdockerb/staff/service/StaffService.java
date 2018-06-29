package com.gao.eurekaclientdockerb.staff.service;


import com.gao.eurekaclientdockerb.staff.vo.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getStaffAll() throws Exception;

}
