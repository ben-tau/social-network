package socialNetwork.model;

public enum TypeContrat {
	CDI("Contrat à durée indéterminée"), CDD("Contrat à durée déterminée"), STAGE("Stagiaire");
	
	private final String label;

	private TypeContrat(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
