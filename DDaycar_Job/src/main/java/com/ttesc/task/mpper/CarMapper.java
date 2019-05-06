package com.ttesc.task.mpper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/5/6 16:18
 */
public interface CarMapper {
    @Select("select id,name from car where createtime>#{lasttime}")
    @ResultType(Map.class)
    List<Map<String,Object>> queryLast(@Param("lasttime")String lasttime);
    @Select("select id,name from car")
    @ResultType(Map.class)
    List<Map<String,Object>> queryAll();
}
