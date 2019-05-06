package com.ttesc.ddaycar_carapi.config;

import com.ttesc.ddaycar_carapi.filter.CrosFilter;
import com.ttesc.ddaycar_carapi.filter.HelloFilter;
import com.ttesc.ddaycar_carapi.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 *@Author feri
 *@Date Created in 2019/4/29 17:54
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean createFRB(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CrosFilter());
        ArrayList<String> list=new ArrayList<>();
        list.add("/*");
        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean createFR(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new TokenFilter());
        ArrayList<String> list=new ArrayList<>();
        list.add("/*");
        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }

}
