package com.study.springcloud.controller;

import com.study.springcloud.entity.Dept;
import com.study.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 16:09
 */
@RestController
public class DeptConsumerController {


    /**
     * 理解：消费者，不应该有service层~
     * RestTemplate .... 供我们直接调用就可以了！ 注册到Spring中
     * 这里springcloud使用restful模板，而rpc框架dubbo需要接口一致并且远程引用，这是本质区别
     * (地址：url, 实体：Map ,Class<T> responseType)
     * <p>
     * 提供多种便捷访问远程http服务的方法，简单的Restful服务模板~
     */
    @Autowired
    private DeptClientService deptClientService;

    /**
     * 服务提供方地址前缀
     * <p>
     * Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
     */
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * 消费方添加部门信息
     * @param dept
     * @return
     */
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        // postForObject(服务提供方地址(接口),参数实体,返回类型.class)
        return deptClientService.addDept(dept);
    }

    /**
     * 消费方根据id查询部门信息
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        // getForObject(服务提供方地址(接口),返回类型.class)
        return deptClientService.queryById(id);
    }

    /**
     * 消费方查询部门信息列表
     * @return
     */
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.queryAll();
    }

}
