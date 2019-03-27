package com.ziggy.passbook.merchants.dao;

import com.ziggy.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

//MerchantsDao接口
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    //根据id获取商户对象
    Merchants findById(Integer id);

    //根据商户名称获取商户对象
    Merchants findByName(String name);

}
