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
public class Carsub {

    private Integer id;
    private Integer sid;
    private Integer bid;
    private Integer mid;
    /**
     * 公里数 单位公里
     */
    private Integer kilometre;
    /**
     * 车辆的车况信息
     */
    private String carinfo;
    /**
     * 上牌日期
     */
    private Date platedate;
    private String plateaddress;
    /**
     * 后续计划：买新车 买二手车 不用车
     */
    private String plan;
    private Date createtime;
    /**
     * 1初始登记 2预约 3验车 4平台上线 5成交
     */
    private Integer flag;
}