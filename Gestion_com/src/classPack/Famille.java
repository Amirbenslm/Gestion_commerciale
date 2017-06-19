package classPack;

public class Famille {
	private int id_fammille;
	private String nom_famille;
	private int id_taxe;
	public String getNom_famille() {
		return nom_famille;
	}
	public void setNom_famille(String nom_famille) {
		this.nom_famille = nom_famille;
	}
	public int getId_taxe() {
		return id_taxe;
	}
	public void setId_taxe(int id_taxe) {
		this.id_taxe = id_taxe;
	}
	public Famille(int id_fammille, String nom_famille, int id_taxe) {
		super();
		this.id_fammille = id_fammille;
		this.nom_famille = nom_famille;
		this.id_taxe = id_taxe;
	}
	public int getId_fammille() {
		return id_fammille;
	}
	public void setId_fammille(int id_fammille) {
		this.id_fammille = id_fammille;
	}
	
	
}
