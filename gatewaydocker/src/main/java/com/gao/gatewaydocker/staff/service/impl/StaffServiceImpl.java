package com.gao.gatewaydocker.staff.service.impl;


import com.gao.gatewaydocker.mapper.StaffMapper;
import com.gao.gatewaydocker.staff.service.StaffService;
import com.gao.gatewaydocker.vo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: StaffServiceImpl
 * @Date 2018/6/11 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Staff getStaffById(Integer staffId) {
        return staffMapper.selectByPrimaryKey(staffId);
    }

}
