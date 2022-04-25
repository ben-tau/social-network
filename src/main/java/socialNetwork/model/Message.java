package socialNetwork.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "contenu", length = 200)
	private String contenu;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_envoi")
	private Date dateEnvoi;
	@ManyToOne
	@JoinColumn(name = "utilisateur_destinataire_id")
	private Utilisateur utilisateurDestinataire;
	@ManyToOne
	@JoinColumn(name = "utilisateur_expediteur_id")
	private Utilisateur utilisateurExpediteur;
	
	public Message() {
		super();
	}
	
	public Message(String contenu, Date dateEnvoi, Utilisateur utilisateurDestinataire,
			Utilisateur utilisateurExpediteur) {
		super();
		this.contenu = contenu;
		this.dateEnvoi = dateEnvoi;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
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
