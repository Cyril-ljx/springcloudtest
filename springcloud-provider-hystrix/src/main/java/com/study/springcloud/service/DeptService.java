package com.study.springcloud.service;



import com.study.springcloud.entity.Dept;

import java.util.List;

/**
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 13:51
 */

public interface DeptService {

    int addDept(Dept dept);

    Dept queryById(Long deptno);

    List<Dept> queryAll();
}
