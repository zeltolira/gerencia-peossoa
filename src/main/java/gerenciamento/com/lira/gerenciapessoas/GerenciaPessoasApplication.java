package gerenciamento.com.lira.gerenciapessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class GerenciaPessoasApplication {

	@GetMapping
	public String GetHomeTest(){
		return "Gestão de pessoas API. Test ok!";
	}
	public static void main(String[] args) {
		SpringApplication.run(GerenciaPessoasApplication.class, args);
	}

}
