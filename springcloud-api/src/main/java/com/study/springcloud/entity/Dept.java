package com.study.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept(实体类) orm mysql->Dept(表) 类表关系映射
 *
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 11:51
 */

@NoArgsConstructor
@Data
@Accessors(chain = true) //链式写法，详见博客
public class Dept implements Serializable {
    /**
     * 主键
     */
    private Long deptno;
    /**
     * 部门名称
     */
    private String dname;
    /**
     * 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存到多个不同的数据库
     */
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }

}
