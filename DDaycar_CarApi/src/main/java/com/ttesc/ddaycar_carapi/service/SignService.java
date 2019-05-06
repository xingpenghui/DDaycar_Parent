package com.ttesc.ddaycar_carapi.service;

import com.ttesc.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/4/30 11:27
 */
@FeignClient(name = "UserProvider")
public interface SignService {
    @PostMapping("sign/signsave.do")
    public ResultVO sign(int uid);
    @GetMapping("sign/signdays.do")
    public ResultVO days(@RequestParam("uid") int uid);
}
