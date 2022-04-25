package socialNetwork.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "particulier")
@DiscriminatorValue(value = "Particulier")
public class Particulier extends Utilisateur {

	@Column(name = "nom", length = 50)
	private String nom;
	@Column(name = "prenom", length = 50)
	private String prenom;
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Genre genre;
	@Column(name = "cv", length = 200)
	private String cv;
	@Column(name = "nature_handicap", length = 500)
	private String natureHandicap;

	@OneToMany(mappedBy = "particulier")
	private List<Competence> competences = new ArrayList<Competence>();

	@OneToMany(mappedBy = "particulier")
	private List<Candidature> candidatures = new ArrayList<Candidature>();

	public Particulier() {
		super();
	}

	public Particulier(String nom, String prenom, Genre genre, String cv, String natureHandicap,
			List<Competence> competences, List<Candidature> candidatures) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.cv = cv;
		this.natureHandicap = natureHandicap;
		this.competences = competences;
		this.candidatures = candidatures;
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getNatureHandicap() {
		return natureHandicap;
	}

	public void setNatureHandicap(String natureHandicap) {
		this.natureHandicap = natureHandicap;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

}
