package classPack;

public class Taxe {
	private String libelle ;
	private float taux ;
	
	public Taxe(String libelle, float taux) {
		super();
		this.libelle = libelle;
		this.taux = taux;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}

}
