package socialNetwork.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PublicationDto {

	@NotBlank(message = "Message should have at least 3 and max 5000 characters")
	@Size(min = 2, max = 5000, message = "Message should have at least 3 and max 5000 characters")
	private String contenu;

	public PublicationDto() {
		super();
	}
	
	public PublicationDto(String contenu) {
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
