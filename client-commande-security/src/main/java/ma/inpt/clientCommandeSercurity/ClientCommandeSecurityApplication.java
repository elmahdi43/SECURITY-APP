package ma.inpt.clientCommandeSercurity;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ma.inpt.clientCommandeSercurity.client.ClientController;

@SpringBootApplication
@ComponentScan({"ma.inpt.clientCommandeSercurity", "ma.inpt.clientCommandeSercurity.client"})
public class ClientCommandeSecurityApplication {

	public static void main(String[] args) {
		new File(ClientController.uploadDirectory).mkdir();
		SpringApplication.run(ClientCommandeSecurityApplication.class, args);
	}

}
