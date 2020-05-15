package com.liu.provider.dao;

import com.liu.provider.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao {
    public Goods findOneById(int id){
        return new Goods(1,"HUAWEI",3999.00,1000);
    }
}
