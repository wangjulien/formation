package org.formation.proxibanque.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity ClientParticulier heriter de Client
 * 
 * @author JW
 *
 */

@XmlRootElement
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