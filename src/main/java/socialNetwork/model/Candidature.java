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
@Table(name = "candidature")
public class Candidature {

	@Id
	@GeneratedValue
	private long id;
	@Version
	private int version;
	@Column(name = "message", length = 500)
	private String message;

	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Particulier particulier;

	public Candidature() {
		super();
	}
	
	public Candidature(String message, Particulier particulier) {
		super();
		this.message = message;
		this.particulier = particulier;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Particulier getParticulier() {
		return particulier;
	}

	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}

}
