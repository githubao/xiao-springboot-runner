package org.xiao.springboot;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2Doc
public class XiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaoApplication.class, args);
	}
}
