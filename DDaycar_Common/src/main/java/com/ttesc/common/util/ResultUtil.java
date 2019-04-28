package com.ttesc.common.util;

import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.vo.ResultVO;

/**
 *@Author feri
 *@Date Created in 2019/4/28 17:28
 */
public class ResultUtil {
    public static ResultVO exec(boolean istrue,String msg,Object obj){
        ResultVO resultVO=new ResultVO(istrue?SystemConst.OK:SystemConst.ERROR,msg,obj);
        return resultVO;
    }
    public static ResultVO setOK(){
        return exec(true,"OK",null);
    }
    public static ResultVO setERROR(){
        return exec(false,"ERROR",null);
    }
    public static ResultVO setOK(String msg){
        return exec(true,msg,null);
    }

}
