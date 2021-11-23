package com.study.springcloud.controller;

import com.study.springcloud.entity.Dept;
import com.study.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 14:10
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    /**
     * DiscoveryClient 可以用来获取一些配置的信息，得到具体的微服务！
     */
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public int addDept(@RequestBody Dept dept) {
        //因为@RestController=@Controller+@ResponseBody
        //并没有接受请求的@RequestBody,消费者接收的是表单信息，所以不用加，
        // 使用 REST 转发的时候，对象会被作为请求体转发，而且不再是application/x-www-form-urlencoded类型，
        // 所以提供者那边一直收不到数据。
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{deptno}")
    public Dept queryById(@PathVariable("deptno") Long deptno) {
        return deptService.queryById(deptno);
    }

    @GetMapping("/queryAll")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    /**
     * 获取一些注册进来的微服务的信息~，
     *
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }
}
