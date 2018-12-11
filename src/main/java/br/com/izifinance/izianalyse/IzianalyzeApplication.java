package br.com.izifinance.izianalyse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import br.com.izifinance.izianalyse.model.User;
//import br.com.izifinance.izianalyse.repositories.UserRepository;

@EnableAsync
@EnableSpringDataWebSupport
@SpringBootApplication
public class IzianalyzeApplication implements CommandLineRunner {

	@Autowired
	//private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(IzianalyzeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String string = encoder.encode("lorena200");
//		repository.save(new User("thiago", "thiagoconsultor1@gmail.com", string));
		
	}
}
