package com.winter;

		import com.github.pagehelper.PageHelper;
		import org.mybatis.spring.annotation.MapperScan;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.Bean;

		import java.util.Properties;

@SpringBootApplication
@MapperScan("com.winter.mapper")
public class SpringbootMybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
	}

}
