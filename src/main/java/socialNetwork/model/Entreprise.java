package socialNetwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entreprise")
@DiscriminatorValue(value = "Entreprise")
public class Entreprise extends Utilisateur{

	@Column(name = "nom", length = 100)
	private String nom;
	@Column(name = "nombre_employes")
	private Long nombreEmployes;
	@Column(name = "presentation")
	private String presentation;
	@Column(name = "site_web")
	private String siteWeb;
	@Column(name = "date_creation")
	private Date dateCreation;
	@OneToMany(mappedBy="entreprise")
	private List<OffreEmploi> offresEmploi = new ArrayList<OffreEmploi>();
	@OneToMany(mappedBy="entreprise")
	private List<EntrepriseSecteurActivite> entrepriseSecteurActivite = new ArrayList<EntrepriseSecteurActivite>();

	public Entreprise() {
		super();
	}
	
	public Entreprise(String nom, Long nombreEmployes, String presentation, String siteWeb, Date dateCreation,
			List<OffreEmploi> offresEmploi, List<EntrepriseSecteurActivite> entrepriseSecteurActivite) {
		super();
		this.nom = nom;
		this.nombreEmployes = nombreEmployes;
		this.presentation = presentation;
		this.siteWeb = siteWeb;
		this.dateCreation = dateCreation;
		this.offresEmploi = offresEmploi;
		this.entrepriseSecteurActivite = entrepriseSecteurActivite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getNombreEmployes() {
		return nombreEmployes;
	}

	public void setNombreEmployes(Long nombreEmployes) {
		this.nombreEmployes = nombreEmployes;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<OffreEmploi> getOffresEmploi() {
		return offresEmploi;
	}

	public void setOffresEmploi(List<OffreEmploi> offresEmploi) {
		this.offresEmploi = offresEmploi;
	}

	public List<EntrepriseSecteurActivite> getEntrepriseSecteurActivite() {
		return entrepriseSecteurActivite;
	}

	public void setEntrepriseSecteurActivite(List<EntrepriseSecteurActivite> entrepriseSecteurActivite) {
		this.entrepriseSecteurActivite = entrepriseSecteurActivite;
	}


}
