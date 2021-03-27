package com.ljp;

import org.apache.ibatis.ognl.MethodAccessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import com.ljp.mapper.UserMapper;

@SpringBootApplication
@MapperScan(basePackageClasses= {UserMapper.class})
@EnableAspectJAutoProxy
public class MainApp {
	
	MethodAccessor ma;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApp.class, args);
	}
	
	@Bean
	public RestTemplate getResttemplate(){

		return new RestTemplate();

	}
}
