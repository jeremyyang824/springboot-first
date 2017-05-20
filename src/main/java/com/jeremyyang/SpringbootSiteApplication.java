package com.jeremyyang;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;

/**
 *  说明：@SpringBootApplication 相当于以下3个注解：
 *	1. @Configuration
 *	2. @ComponentScan
 * 	3. @EnableAutoConfiguration
 */
@SpringBootApplication
@EnableTransactionManagement
public class SpringbootSiteApplication
		extends SpringBootServletInitializer implements WebApplicationInitializer {

	//声明Bean工厂方法
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootSiteApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSiteApplication.class, args);
	}
}
