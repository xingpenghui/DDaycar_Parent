package com.ttesc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.entity.car.Car;
import com.ttesc.server.dao.CarDao;
import com.ttesc.server.service.CarService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Feri
 * @since 2019-05-06
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {

    @Override
    public ResultVO queryHot() {

        return ResultUtil.exec(true,"OK",getBaseMapper().queryHot());
    }
}
