package at.schrogl.fsdineros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FsDinerosApplication {

	@RequestMapping("/")
	String home() {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(FsDinerosApplication.class, args);
	}
}
