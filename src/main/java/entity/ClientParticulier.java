package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author JW NH
 *
 */

@Entity
@Table(name = "clientparticulier")
public class ClientParticulier extends Client {

	private String nom;
	private String prenom;

	public ClientParticulier() {
		super();
	}

	public ClientParticulier(String nom, String prenom, String refClient, Adresse adresse) {
		super(refClient, adresse);
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}