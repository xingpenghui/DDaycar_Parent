package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/4/30 15:41
 */
@FeignClient(name = "UserProvider")
public interface AwardService {
    @PostMapping("award/creataward.do")
    ResultVO create(@RequestParam("uid") int uid);
}
