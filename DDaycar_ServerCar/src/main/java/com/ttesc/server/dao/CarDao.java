package com.ttesc.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttesc.entity.car.Car;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:29
 */
public interface CarDao extends BaseMapper<Car> {
    @Select("select * from car limit 12")
    List<Car> queryHot();
}
