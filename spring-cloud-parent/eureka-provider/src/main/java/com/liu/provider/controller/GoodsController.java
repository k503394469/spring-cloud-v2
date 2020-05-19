package com.liu.provider.controller;

import com.liu.provider.domain.Goods;
import com.liu.provider.service.GoodsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Value("${server.port}")
    private int port;
    @GetMapping("/findOne/{id}")
    @HystrixCommand(fallbackMethod = "findOne_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//配置超时降级时间配置,默认1s(1000ms)
    })//如果此方法失败(降级),则调用findOne_fallback
    public Goods findOne(@PathVariable int id){
//        int i=3/0;
//        Thread.sleep(3000);
        Goods goods = goodsService.findOneById(id);
        goods.setTitle(goods.getTitle()+":"+port);
        return goods;
    }

    /**
     * 降级
     * 1,出现Exception
     * 2,服务调用超时
     */
    /**
     * 降级方法:
     * 1,返回值和参数需要和原方法一致
     */
    public Goods findOne_fallback(int id){
        Goods goods = new Goods();
        goods.setTitle("findOne降级方法");
        return goods;
    }
}
