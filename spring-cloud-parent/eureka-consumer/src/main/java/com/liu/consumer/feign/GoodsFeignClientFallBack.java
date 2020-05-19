package com.liu.consumer.feign;

import com.liu.consumer.domain.Goods;
import org.springframework.stereotype.Component;

/**
 * feign客户端降级处理类
 */
@Component
public class GoodsFeignClientFallBack implements GoodsFeignClient{
    @Override
    public Goods findGoodsById(int id) {
        Goods goods = new Goods();
        goods.setTitle("消费端降级");
        return goods;
    }
}
