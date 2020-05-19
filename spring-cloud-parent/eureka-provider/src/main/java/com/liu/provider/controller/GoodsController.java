package com.liu.provider.controller;

import com.liu.provider.domain.Goods;
import com.liu.provider.service.GoodsService;
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
    public Goods findOne(@PathVariable int id){
        Goods goods = goodsService.findOneById(id);
        goods.setTitle(goods.getTitle()+":"+port);
        return goods;
    }
}
