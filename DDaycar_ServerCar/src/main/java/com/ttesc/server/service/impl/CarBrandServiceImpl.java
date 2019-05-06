package com.ttesc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttesc.entity.car.Carbrand;
import com.ttesc.server.dao.CarBrandDao;
import com.ttesc.server.service.CarBrandService;
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
public class CarBrandServiceImpl extends ServiceImpl<CarBrandDao, Carbrand> implements CarBrandService {

}
