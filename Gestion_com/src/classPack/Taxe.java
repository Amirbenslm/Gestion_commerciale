package classPack;

public class Taxe {
	private int id_taxe ;
	private String libelle ;
	private float taux ;
	
	
	public Taxe(int id_taxe, String libelle, float taux) {
		this.id_taxe = id_taxe;
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
	public int getId_taxe() {
		return id_taxe;
	}
	public void setId_taxe(int id_taxe) {
		this.id_taxe = id_taxe;
	}

}
