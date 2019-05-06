package com.ttesc.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.car.Car;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:31
 */
public interface CarService extends IService<Car> {
    ResultVO queryHot();
}
