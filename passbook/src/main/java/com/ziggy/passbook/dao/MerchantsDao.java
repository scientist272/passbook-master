package com.ziggy.passbook.dao;

import com.ziggy.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//MerchantsDao接口
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    //通过id获取商户对象
    Merchants findById(Integer id);

    //根据商户名称获取商户对象
    Merchants findByName(String name);

    //根据商户ids获取多个商户对象
    List<Merchants> findByIdIn(List<Integer> ids);
}
