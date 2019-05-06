package com.ttesc.esapi.controller;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.esapi.model.BaseBean;
import com.ttesc.esapi.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/5/6 10:21
 */
@RestController
@Api(value = "操作Elasticsearch",tags = "操作Elasticsearch服务器")
public class BaseController {
    @Autowired
    private BaseService baseService;

    @ApiOperation(value = "分页查找",notes = "分页查询索引数据")
    @GetMapping("/elastic/page.do")
    public ResultVO page(String index,String type,int page,int limit){
        return baseService.queryPage(index, type, page, limit);
    }
    @ApiOperation(value = "模糊查找",notes = "模糊查询索引数据")
    @GetMapping("/elastic/like.do")
    public ResultVO like(String index,String type,String field,String msg){
        return baseService.queryLike(index, type, field, msg);
    }
    @ApiOperation(value = "新增数据",notes = "新增数据")
    @PostMapping("/elastic/save.do")
    public ResultVO save(@RequestBody BaseBean baseBean){
        return baseService.save( baseBean);
    }
    @ApiOperation(value = "删除数据",notes = "删除数据")
    @DeleteMapping("/elastic/delete.do")
    public ResultVO delete(@RequestBody BaseBean baseBean){
        return baseService.delete(baseBean);
    }

    @GetMapping("/elastic/single.do")
    public ResultVO single(String index,String type,int id){
        return baseService.querySingle(index, type, id);
    }
    @ApiOperation(value = "批量新增数据",notes = "批量新增数据")
    @PostMapping("/elastic/savebatch.do")
    public ResultVO save(@RequestBody List<BaseBean> baseBean){
        return baseService.saveBatch( baseBean);
    }





}
