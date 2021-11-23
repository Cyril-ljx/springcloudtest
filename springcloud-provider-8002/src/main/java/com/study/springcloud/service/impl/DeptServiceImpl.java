package com.study.springcloud.service.impl;


import com.study.springcloud.entity.Dept;
import com.study.springcloud.mapper.DeptDao;
import com.study.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 13:51
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public int addDept(Dept dept) {
        int result = deptDao.insert(dept);
        return result;
    }

    @Override
    public Dept queryById(Long deptno) {
        return deptDao.selectById(deptno);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.selectList(null);
    }
}
