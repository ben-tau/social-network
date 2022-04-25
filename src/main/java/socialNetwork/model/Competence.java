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
@Table(name = "competence")
public class Competence {
	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	@Column(name = "nom", length = 50)
	private String nom;

	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Particulier particulier;

	public Competence() {
		super();
	}

	public Competence(String nom, Particulier particulier) {
		super();
		this.nom = nom;
		this.particulier = particulier;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Particulier getParticulier() {
		return particulier;
	}

	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}

}
