package com.sjtu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class Druidconfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    /**
     * 数据源注册
     */
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * StatViewServlet的用途包括：
     * 提供监控信息展示的html页面
     * 提供监控信息的JSON API
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams=new HashMap<>();

        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","0000");
        initParams.put("allow","");
        //initParams.put("deny","192.168.0.19");

        bean.setInitParameters(initParams);
        return bean;
    }



}
