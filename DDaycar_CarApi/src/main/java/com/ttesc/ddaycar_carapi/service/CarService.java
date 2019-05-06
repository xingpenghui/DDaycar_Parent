package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/5/6 09:56
 */
@FeignClient(name = "CarProvider")
public interface CarService {
    @GetMapping("/car/hot.do")
    ResultVO hot(@RequestParam("type")int type);
}
