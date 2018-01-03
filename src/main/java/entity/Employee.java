package entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Entity abstract Employee (strategy TABLE PER CLASS)
 * 
 * @author JW NH
 *
 */

@XmlRootElement
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(unique = true)
	private String refEmployee;

	private String nom;
	private String prenom;

	@Embedded
	private Adresse adresse;

	private char role;
	
	@Column(unique = true)
	private String login;
	
	private String password;
	
	public Employee() {
		super();
		this.adresse = new Adresse();
	}

	public Employee(String nom, String prenom, String refEmployee, Adresse adresse) {
		super();
		this.refEmployee = refEmployee;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.login = nom;
		this.password = "test";
		this.adresse = new Adresse();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefEmployee() {
		return refEmployee;
	}

	public void setRefEmployee(String refEmployee) {
		this.refEmployee = refEmployee;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}