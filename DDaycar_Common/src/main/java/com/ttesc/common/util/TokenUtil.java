package com.ttesc.common.util;

import com.alibaba.fastjson.JSON;
import com.ttesc.common.constsys.SystemConst;
import com.ttesc.common.vo.TokenVO;
import org.json.JSONObject;

import java.util.Date;
import java.util.Random;



/**
 *@Author feri
 *@Date Created in 2019/4/29 14:46
 */
public class TokenUtil {
    //生成Token
    public static String createToken(int id,String msg){
        TokenVO tokenVO=new TokenVO();
        tokenVO.setContent(msg);
        tokenVO.setUid(id);
        tokenVO.setDate(new Date());
        tokenVO.setRandom(new Random().nextLong());
        String str=JSON.toJSONString(tokenVO);

        return EncryptionUtil.AESEnc(SystemConst.TOKENKEY,str);
    }
    //解析Token
    public static TokenVO parseToken(String msg){
        String json=EncryptionUtil.AESDec(SystemConst.TOKENKEY,msg);
        return JSON.parseObject(json,TokenVO.class);
    }
    //更新Token
    public static String updateToken(String token){
        String json=EncryptionUtil.AESDec(SystemConst.TOKENKEY,token);
        TokenVO tokenVO= JSON.parseObject(json,TokenVO.class);
        tokenVO.setDate(new Date());
        tokenVO.setRandom(new Random().nextLong());
        return EncryptionUtil.AESEnc(SystemConst.TOKENKEY,JSON.toJSONString(tokenVO));
    }

}
