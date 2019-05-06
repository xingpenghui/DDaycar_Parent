package com.ttesc.entity.car;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 车辆基本表
 * </p>
 *
 * @author Feri
 * @since 2019-05-06
 */
@Data
public class Car  {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String carimg;
    private Date caryear;
    private Integer carkm;
    private String caraddress;
    private Integer carprice;
    private Integer caroldprice;
    private Integer flag;
    private Integer sort;
    private Integer bid;
    private Integer mid;
}
