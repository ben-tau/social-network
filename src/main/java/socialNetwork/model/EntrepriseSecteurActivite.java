package socialNetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "entreprise_secteur_activite")
public class EntrepriseSecteurActivite{
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;

	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	@ManyToOne
	@JoinColumn(name = "secteur_activite_id")
	private SecteurActivite secteurActivite;

	public EntrepriseSecteurActivite() {
		super();
	}

	public EntrepriseSecteurActivite(Entreprise entreprise, SecteurActivite secteurActivite) {
		super();
		this.entreprise = entreprise;
		this.secteurActivite = secteurActivite;
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

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public SecteurActivite getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(SecteurActivite secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	


}
