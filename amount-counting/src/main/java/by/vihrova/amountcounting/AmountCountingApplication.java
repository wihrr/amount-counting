package by.vihrova.amountcounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AmountCountingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmountCountingApplication.class, args);
	}

}
