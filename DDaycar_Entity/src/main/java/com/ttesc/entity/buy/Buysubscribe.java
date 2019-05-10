package com.ttesc.entity.buy;

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
public class Buysubscribe {

    private Integer id;
    private Integer uid;
    /**
     * 看车方式：1 到店 
     */
    private Integer type;
    /**
     * 预约日期
     */
    private Date subdate;
    private Date createtime;
    /**
     * 标记位 1已预约 2已沟通 3有效 4、失效
     */
    private Integer flag;

}