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
@Table(name = "commentaire")
public class Commentaire {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name="contenu",length = 4000)
	private String contenu;
	@Column(name="date_publication")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datePublication;
	@ManyToOne
	@JoinColumn(name = "publication_id")
	private Publication publication;
	
	public Commentaire() {
		super();
	}

	public Commentaire(String contenu, Date datePublication) {
		super();
		this.contenu = contenu;
		this.datePublication = datePublication;
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

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	

}
