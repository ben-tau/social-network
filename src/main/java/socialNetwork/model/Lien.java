package socialNetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "lien")
public class Lien {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "is_accepted")
	private boolean isAccepted;
	@Enumerated(EnumType.STRING)
	@Column(name = "type", length = 20)
	private Type type;
	@ManyToOne
	@JoinColumn(name = "utilisateur_destinataire_id")
	private Utilisateur utilisateurDestinataire;
	@ManyToOne
	@JoinColumn(name = "utilisateur_expediteur_id")
	private Utilisateur utilisateurExpediteur;
	
	public Lien() {
		super();
	}

	public Lien(boolean isAccepted, Type type, Utilisateur utilisateurDestinataire, Utilisateur utilisateurExpediteur) {
		super();
		this.isAccepted = isAccepted;
		this.type = type;
		this.utilisateurDestinataire = utilisateurDestinataire;
		this.utilisateurExpediteur = utilisateurExpediteur;
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

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Utilisateur getUtilisateurDestinataire() {
		return utilisateurDestinataire;
	}

	public void setUtilisateurDestinataire(Utilisateur utilisateurDestinataire) {
		this.utilisateurDestinataire = utilisateurDestinataire;
	}

	public Utilisateur getUtilisateurExpediteur() {
		return utilisateurExpediteur;
	}

	public void setUtilisateurExpediteur(Utilisateur utilisateurExpediteur) {
		this.utilisateurExpediteur = utilisateurExpediteur;
	}


	
}

