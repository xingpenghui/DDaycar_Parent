package com.ttesc.entity.car;

import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 型号
 * </p>
 *
 * @author Feri
 * @since 2019-05-06
 */
@Data
public class Carmodel  {

    private static final long serialVersionUID = 1L;


    private Integer id;
    private Integer bid;
    private String name;
    /**
     * 排量
     */
    private Float displacement;
    /**
     * 款系
     */
    private Integer sincere;
    /**
     * 变速箱
     */
    private String gearbox;
    /**
     * 车位数
     */
    private Integer seanums;
}