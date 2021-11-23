package com.study.springcloud.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 13:47
 */
@Mapper
public interface DeptDao extends BaseMapper<Dept> {
}
