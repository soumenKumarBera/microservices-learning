package in.kumar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroPlotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPlotApplication.class, args);
	}

}
