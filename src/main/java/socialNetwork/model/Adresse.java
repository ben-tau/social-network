package socialNetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "adresse")
public class Adresse {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name="nom",length = 100)
	private String nom;
	@Column(name="numero_de_rue",length = 100)
	private int numeroDeRue;
	@Column(name="complement",length = 100)
	private String complement;
	@Column(name="ville",length = 100)
	private String ville;
	@Column(name="code_postal",length = 25)
	private String codePostal;
	@OneToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Adresse() {
		super();
	}

	public Adresse(String nom, int numeroDeRue, String complement, String ville, String codePostal) {
		super();
		this.nom = nom;
		this.numeroDeRue = numeroDeRue;
		this.complement = complement;
		this.ville = ville;
		this.codePostal = codePostal;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumeroDeRue() {
		return numeroDeRue;
	}

	public void setNumeroDeRue(int numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
