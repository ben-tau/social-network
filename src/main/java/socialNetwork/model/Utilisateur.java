package socialNetwork.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "utilisateur")
@DiscriminatorColumn(name="type_utilisateur",discriminatorType=DiscriminatorType.STRING)
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name="nom_utilisateur",length = 100)
	private String nomUtilisateur;
	@Column(name="mot_de_passe",length = 100)
	private String motDePasse;
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Role role;
	@Column(name="email",length = 255)
	private String email;
	@Column(name="telephone",length = 20)
	private String telephone;
	@OneToOne(mappedBy = "utilisateur")
	private Adresse adresse = null;
	@OneToMany(mappedBy = "utilisateur")
	private List<Publication> publications = new ArrayList<Publication>();
	@OneToMany(mappedBy = "utilisateur")
	private List<Notification> notifications = new ArrayList<Notification>();
	@OneToMany(mappedBy = "utilisateurExpediteur")
	private List<Message> messageExp = new ArrayList<Message>();
	@OneToMany(mappedBy = "utilisateurDestinataire")
	private List<Message> messageDest = new ArrayList<Message>();
	@OneToMany(mappedBy = "utilisateurExpediteur")
	private List<Lien> lienExp = new ArrayList<Lien>();
	@OneToMany(mappedBy = "utilisateurDestinataire")
	private List<Lien> lienDest = new ArrayList<Lien>();
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nomUtilisateur, String motDePasse, Role role, String email, String telephone,
			Adresse adresse, List<Publication> publications, List<Notification> notifications, List<Message> messageExp,
			List<Message> messageDest, List<Lien> lienExp, List<Lien> lienDest) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.role = role;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.publications = publications;
		this.notifications = notifications;
		this.messageExp = messageExp;
		this.messageDest = messageDest;
		this.lienExp = lienExp;
		this.lienDest = lienDest;
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
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Publication> getPublications() {
		return publications;
	}
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public List<Message> getMessageExp() {
		return messageExp;
	}
	public void setMessageExp(List<Message> messageExp) {
		this.messageExp = messageExp;
	}
	public List<Message> getMessageDest() {
		return messageDest;
	}
	public void setMessageDest(List<Message> messageDest) {
		this.messageDest = messageDest;
	}
	public List<Lien> getLienExp() {
		return lienExp;
	}
	public void setLienExp(List<Lien> lienExp) {
		this.lienExp = lienExp;
	}
	public List<Lien> getLienDest() {
		return lienDest;
	}
	public void setLienDest(List<Lien> lienDest) {
		this.lienDest = lienDest;
	}


}
