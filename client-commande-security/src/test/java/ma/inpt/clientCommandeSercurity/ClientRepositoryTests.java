package ma.inpt.clientCommandeSercurity;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ma.inpt.clientCommandeSercurity.client.Client;
import ma.inpt.clientCommandeSercurity.client.ClientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClientRepositoryTests {
	@Autowired
	private ClientRepository repo;
	
	@Test
	public void testCreateClient() {
		Client savedClient=repo.save(new Client());
		
		assertThat(savedClient.getId()).isGreaterThan(0);
	}
	
}
