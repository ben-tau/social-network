package socialNetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "offre_emploi")
public class OffreEmploi{
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "intitule")
	private String intitule;
	@Column(name = "description")
	private String description;
	@Column(name = "salaire")
	private String salaire;
	@Column(name = "type_contrat")
	private TypeContrat typeContrat;

	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;

	public OffreEmploi() {
		super();
	}

	public OffreEmploi(String intitule, String description, String salaire,
			TypeContrat typeContrat, Entreprise entreprise) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.salaire = salaire;
		this.typeContrat = typeContrat;
		this.entreprise = entreprise;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSalaire() {
		return salaire;
	}


	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}


	public TypeContrat getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	


}
