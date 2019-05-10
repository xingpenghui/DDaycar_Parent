package com.ttesc.serversale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttesc.entity.sale.Saleuser;
import com.ttesc.serversale.mapper.SaleuserMapper;
import com.ttesc.serversale.service.SaleuserService;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/5/10 13:55
 */
@Service
public class SaleUserServiceImpl extends ServiceImpl<SaleuserMapper,Saleuser> implements SaleuserService {
}
