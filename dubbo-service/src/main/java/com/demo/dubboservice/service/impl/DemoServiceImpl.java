package com.demo.dubboservice.service.impl;

//import com.alibaba.dubbo.config.annotation.Service;
import com.demo.common.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(registry = "dubboRegistry", timeout = 3000, version = "1.0", retries = 3, loadbalance = "random", actives = 5)
public class DemoServiceImpl implements DemoService {
    @Value("${server.port}")
    private String port;
    @Override
    public String hello() {
        return "服务端口：" + port + "动物园里有大西几! 小凶许! 小脑斧! 梅发怒! 小福泥! 小海疼! 发福蝶! 大鸡居! 大飞囊! 大lai流! 强颈怒! 大蟒鞋! 小白去! 鸵寮! 大带许! 大穷猫! 大诺坨! 大你鱼! 丹鼎货! 小乌堆!";
    }
}
