package lk.ijse.notecollectorusingspringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NoteCollectorUsingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteCollectorUsingSpringbootApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
