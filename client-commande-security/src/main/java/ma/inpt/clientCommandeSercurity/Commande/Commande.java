package ma.inpt.clientCommandeSercurity.Commande;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ma.inpt.clientCommandeSercurity.client.Client;

@Entity
public class Commande {
	@Id
	private Long id_commande;
	@Column(length=128)
	private String date;
	@ManyToOne
	@JoinColumn(name="client_id")
	
	private Client client;
	
	
	public Commande() {
		
	}
	public Commande(Long id_commande, String date, Client client) {
		
		this.id_commande = id_commande;
		this.date = date;
		this.client = client;
	}
	public Long getId_commande() {
		return id_commande;
	}
	public void setId_commande(Long id_commande) {
		this.id_commande = id_commande;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
	
	