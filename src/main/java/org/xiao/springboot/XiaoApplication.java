package org.xiao.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class XiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaoApplication.class, args);
	}
}
