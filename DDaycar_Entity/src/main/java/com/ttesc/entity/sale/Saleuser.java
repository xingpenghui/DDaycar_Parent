package com.ttesc.entity.sale;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-05-10
 */
@Data
public class Saleuser {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private Date createtime;
    /**
     * 1初识 2登记车 3验车 4平台上线 5成交
     */
    private Integer flag;
}