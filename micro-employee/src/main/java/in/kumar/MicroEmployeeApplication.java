package in.kumar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // apiConnection
@EnableEurekaClient //EurekaServerConnection
@SpringBootApplication
public class MicroEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroEmployeeApplication.class, args);
	}

}
