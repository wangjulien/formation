package entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * 
 * @author JW NH
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({ @NamedQuery(name = "findAllClients", query = "select m from Client m"),
		@NamedQuery(name = "findClientsByConseillerId", query = "select m from Client m join m.conseiller c "
				+ "where c.id = :conid"),
		@NamedQuery(name = "findParticulierClientsByConseillerId", query = "select m from ClientParticulier m join m.conseiller c "
				+ "where c.id = :conid"),
		@NamedQuery(name = "findEntrepriseClientsByConseillerId", query = "select m from ClientEntreprise m join m.conseiller c "
				+ "where c.id = :conid") })
public abstract class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String refClient;

	@Embedded
	private Adresse adresse;

	@OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private CompteCourant compteCourant;

	@OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private CompteEpargne compteEpargne;

	@ManyToOne
	private Conseiller conseiller;

	public Client() {
		super();
		adresse = new Adresse();
		
		this.setCompteCourant(new CompteCourant());
		this.setCompteEpargne(new CompteEpargne());
	}

	public Client(String refClient, Adresse adresse) {
		super();
		this.refClient = refClient;
		this.adresse = adresse;

		this.setCompteCourant(new CompteCourant());
		this.setCompteEpargne(new CompteEpargne());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefClient() {
		return refClient;
	}

	public void setRefClient(String refClient) {
		this.refClient = refClient;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller monConseiller) {
		this.conseiller = monConseiller;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		compteCourant.setClient(this);
		this.compteCourant = compteCourant;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		compteEpargne.setClient(this);
		this.compteEpargne = compteEpargne;
	}

	public abstract String getNom();

	public abstract void setNom(String nom);

	public abstract String getPrenom();

	public abstract void setPrenom(String prenom);
}