package com.liu.consumer.controller;

import com.liu.consumer.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 订单调用商品
 * 服务调用方
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") int id){
        /**
         * 动态从EurekaServer中获取消息提供者的ip和端口
         * 1,注入DiscoveryClient
         * 2,调用方法获取
         *
         * ********
         * 以后Provider可能是集群,所以获得List
         */

        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");//获取消息提供方应用名,从而获得ip
        if (instances.size()==0||instances==null){
            //没有数据
            return null;
        }
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        System.out.println(host+":"+port);
        String url="http://"+host+":"+port+"/goods/findOne/"+id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        //远程调用GoodsService中的方法
        return goods;
    }

    /**
     * 使用Ribbon简化restTemplate调用
     * 1,声明RestTemp的Bean的时候添加@LoadBalanced
     * 2,使用restTemplate发请求,定义url时,host:port替换为服务提供方的应用名
     * @param id
     * @return
     */
    @GetMapping("/goods2/{id}")
    public Goods findGoodsById2(@PathVariable("id") int id){
        String url="http://EUREKA-PROVIDER/goods/findOne/"+id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        //远程调用GoodsService中的方法
        return goods;
    }
}
