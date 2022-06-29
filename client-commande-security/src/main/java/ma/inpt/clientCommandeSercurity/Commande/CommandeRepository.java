package ma.inpt.clientCommandeSercurity.Commande;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	List<Commande> findAllByClient_Prenom(String prenom);
	
	List<Commande> findAllByClient_id(Long id);
}

