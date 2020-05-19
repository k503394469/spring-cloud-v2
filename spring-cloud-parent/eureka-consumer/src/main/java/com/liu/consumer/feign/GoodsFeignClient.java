package com.liu.consumer.feign;

import com.liu.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign声明式接口.发起远程调用,简化
 *
 * String url="http://EUREKA-PROVIDER/goods/findOne/"+id;
 * Goods goods = restTemplate.getForObject(url, Goods.class);
 *
 * 1,接口上添加@FeignClient
 *          1>设置Value属性为服务提供者名
 * 2,编写接口方法,方法规则和提供方保持一致
 */
@FeignClient(value = "EUREKA-PROVIDER")
public interface GoodsFeignClient {
    @GetMapping("/goods/findOne/{id}")
    public Goods findGoodsById(@PathVariable int id);
}
