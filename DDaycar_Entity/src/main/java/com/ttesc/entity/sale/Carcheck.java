package com.ttesc.entity.sale;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-05-10
 */
@Data
public class Carcheck {

    private Integer id;
    private Integer csid;
    /**
     * 验车时间
     */
    private Date checktime;
    /**
     * 1 固定时间验车 2 客服联系
     */
    private Integer checktype;
    /**
     * 详细地址
     */
    private String checkaddress;
    /**
     * 1、初始登录 2、客服确认 3、安排验车师 4、检验 5、签约 6、二次验车 7、上架
     */
    private Integer flag;

}