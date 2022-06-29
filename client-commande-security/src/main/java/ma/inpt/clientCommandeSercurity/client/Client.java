package ma.inpt.clientCommandeSercurity.client;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
    private Long id;
    @Column(length=10, nullable=false, unique=true)
	private String nom;
    @Column(length=10, nullable=false)
	private String prenom;
    @Column(length=45, nullable=false)
    private String adresse;
    @Column(length=10, nullable=false)
    private String tele;
    @Column(nullable = true, length = 64)
    private String photos;

    public Client() {
    	
    	
    }
    
    
	public Client(Long id, String nom, String prenom, String adresse, String tele, String photos) {
		
		this.id = id;
		this.nom = nom;
		this.prenom= prenom;
		this.adresse = adresse;
		this.tele = tele;
		this.photos= photos;
	}
	
	public Client( String nom, String prenom, String adresse, String tele, String photos) {
		
		this.nom = nom;
		this.prenom= prenom;
		this.adresse = adresse;
		this.tele = tele;
		this.photos=photos;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}
	

	public void setNom(String name) {
		this.nom = name;
	}
	public String getPrenom() {
		return prenom;
	}
	

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public String getPhotos() {
		return photos;
	}


	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	@Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "/client-photos/" + id + "/" + photos;
    }


}
