package com.provide;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableDubboConfiguration
@EnableCaching
public class TbossProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(TbossProvideApplication.class, args);
	}
}
