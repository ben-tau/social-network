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
@Table(name = "notification")
public class Notification {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "texte", length = 200)
	private String texte;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Notification() {
		super();
	}
	
	public Notification(String texte, Utilisateur utilisateur) {
		super();
		this.texte = texte;
		this.utilisateur = utilisateur;
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
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
