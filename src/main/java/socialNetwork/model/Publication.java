package socialNetwork.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "publication")
public class Publication {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 4000)
	private String contenu;
	@Column(name="date_publication")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datePublication;
	@Column(name="visibilite")
	private boolean visibilite = false;
	@Column(name="likes")
	private int likes = 0;
	@OneToMany(mappedBy = "publication")
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Publication() {
		super();
	}
	
	

	public Publication(String contenu) {
		super();
		this.contenu = contenu;
	}



	public Publication(String contenu, Date datePublication, boolean visibilite, int likes,
			List<Commentaire> commentaires, Utilisateur utilisateur) {
		super();
		this.contenu = contenu;
		this.datePublication = datePublication;
		this.visibilite = visibilite;
		this.likes = likes;
		this.commentaires = commentaires;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public boolean isVisibilite() {
		return visibilite;
	}

	public void setVisibilite(boolean visibilite) {
		this.visibilite = visibilite;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
