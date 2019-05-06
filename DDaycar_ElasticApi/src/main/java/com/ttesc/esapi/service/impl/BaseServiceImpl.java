package com.ttesc.esapi.service.impl;

import com.ttesc.common.util.ResultUtil;
import com.ttesc.common.vo.ResultVO;
import com.ttesc.esapi.model.BaseBean;
import com.ttesc.esapi.service.BaseService;
import com.ttesc.esapi.util.TransportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/5/6 14:34
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private TransportUtil transportUtil;
    @Override
    public ResultVO save(BaseBean baseBean) {
        boolean r=transportUtil.save(baseBean.getIndex(),baseBean.getType(),baseBean.getId(),baseBean.getContent());
        return ResultUtil.exec(r,"OK",null);
    }

    @Override
    public ResultVO saveBatch(List<BaseBean> baseBeanList) {
        transportUtil.saveBatch(baseBeanList);
        return ResultUtil.setOK("OK");
    }

    @Override
    public ResultVO delete(BaseBean baseBean) {
        boolean r=transportUtil.delete(baseBean.getIndex(),baseBean.getType(),baseBean.getId());
        return ResultUtil.exec(r,"",null);
    }

    @Override
    public ResultVO deleteBatch(List<BaseBean> baseBeanList) {
        transportUtil.deleteBatch(baseBeanList);
        return ResultUtil.setOK();
    }

    @Override
    public ResultVO queryPage(String index, String type, int page, int count) {
        return ResultUtil.exec(true,"OK",transportUtil.queryPage(index, type, page, count));
    }

    @Override
    public ResultVO queryLike(String index, String type,String field, String msg) {
        return ResultUtil.exec(true,"OK",transportUtil.queryLike(index, type, field, msg));

    }

    @Override
    public ResultVO querySingle(String index, String type, int id) {
        return ResultUtil.exec(true,"OK",transportUtil.queryByid(index,type,id));
    }
}
