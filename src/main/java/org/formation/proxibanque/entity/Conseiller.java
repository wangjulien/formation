package org.formation.proxibanque.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity Conseiller herite de Employee (strategy TABLE PER CLASS)
 * Il possede une liste de Client
 * 
 * @author JW
 *
 */

@XmlRootElement
@Entity
@NamedQueries({ @NamedQuery(name = "findAllConseiller", query = "select m from Conseiller m"),
	@NamedQuery(name = "findConseillersByGerandId", query = "select m from Conseiller m join m.gerant c where c.id = :gerid") })
@Table(name = "conseiller")
public class Conseiller extends Employee {

	public static final char ROLE_CONSEILLER = 'C';
	
	@ManyToOne
	private Gerant gerant;

	@OneToMany(mappedBy = "conseiller", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Client> clientsList = new ArrayList<>();

	public Conseiller() {
		super();
		super.setRole(ROLE_CONSEILLER);
	}

	public Conseiller(String nom, String prenom, String refEmployee, Adresse adresse) {
		super(nom, prenom, refEmployee, adresse);
		super.setRole(ROLE_CONSEILLER);
	}

	public void addClient(Client c) {
		c.setConseiller(this);
		clientsList.add(c);
	}

	public void deleteClient(Client c) {
		c.setConseiller(null);
		clientsList.remove(c);
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Client> getClientsList() {
		return clientsList;
	}

	public void setClientsList(List<Client> clientsList) {
		this.clientsList = clientsList;
	}
}