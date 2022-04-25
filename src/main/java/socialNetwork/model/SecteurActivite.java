package socialNetwork.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "secteur_activite")
public class SecteurActivite{
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="secteurActivite")
	private List<EntrepriseSecteurActivite> entrepriseSecteurActivite = new ArrayList<EntrepriseSecteurActivite>();

	public SecteurActivite() {
		super();
	}

	public SecteurActivite(String nom,
			List<EntrepriseSecteurActivite> entrepriseSecteurActivite) {
		super();
		this.nom = nom;
		this.entrepriseSecteurActivite = entrepriseSecteurActivite;
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

	public List<EntrepriseSecteurActivite> getEntrepriseSecteurActivite() {
		return entrepriseSecteurActivite;
	}

	public void setEntrepriseSecteurActivite(List<EntrepriseSecteurActivite> entrepriseSecteurActivite) {
		this.entrepriseSecteurActivite = entrepriseSecteurActivite;
	}


}
