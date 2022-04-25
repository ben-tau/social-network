package socialNetwork.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CommentaireDto {

	@NotEmpty(message="Firstname may not be empty")
	@Size(min = 2,max = 5000, message = "Le contenu doit être entre 2 et 5000 caractères")
	private String contenu;
	
	public CommentaireDto() {
		super();
	}

	public CommentaireDto(String contenu) {
		super();
		this.contenu = contenu;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	


}
