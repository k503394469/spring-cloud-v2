package com.liu.provider.service;

import com.liu.provider.dao.GoodsDao;
import com.liu.provider.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    public Goods findOneById(int id){
        return goodsDao.findOneById(id);
    }
}
