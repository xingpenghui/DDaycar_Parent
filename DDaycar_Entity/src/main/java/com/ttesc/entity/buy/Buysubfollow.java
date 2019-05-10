package com.ttesc.entity.buy;

import lombok.Data;

import java.util.Date;
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
public class Buysubfollow  {
    private Integer id;
    private Integer bid;
    private String content;
    private Date createtime;
    private String servicename;
}
