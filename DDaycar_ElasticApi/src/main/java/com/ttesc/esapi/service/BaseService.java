package com.ttesc.esapi.service;

import com.ttesc.common.vo.ResultVO;
import com.ttesc.esapi.model.BaseBean;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/5/6 10:20
 */
public interface BaseService {
    //新增
    ResultVO save(BaseBean baseBean);
    //批量新增
    ResultVO saveBatch(List<BaseBean> baseBeanList);
    //删除
    ResultVO delete(BaseBean baseBean);
    //批量删除
    ResultVO deleteBatch(List<BaseBean> baseBeanList);
    //分页 查询
    ResultVO queryPage(String index,String type,int page,int count);
    //模糊查询
    ResultVO queryLike(String index,String type,String field,String msg);
    //查询单个
    ResultVO querySingle(String index,String type,int id);

}
