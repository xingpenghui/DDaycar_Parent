package com.ttesc.entity.car;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author Feri
 * @since 2019-05-06
 */
@Data
public class Carbrand {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String country;
    private String icon;
    private int flag;//品牌类型：1 普通 2 精选

}
