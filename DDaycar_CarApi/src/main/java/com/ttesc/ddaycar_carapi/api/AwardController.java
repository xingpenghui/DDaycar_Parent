package com.ttesc.ddaycar_carapi.api;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.ddaycar_carapi.service.AwardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/4/30 15:42
 */
@Api(value = "抽奖操作",tags = "抽奖啦")
@RestController
public class AwardController {
    @Autowired
    private AwardService awardService;
    @ApiOperation(value = "抽奖",notes = "开始抽奖")
    @PostMapping("award/creataward.do")
    public ResultVO create(@RequestParam("uid") int uid){
        return awardService.create(uid);
    }
}
