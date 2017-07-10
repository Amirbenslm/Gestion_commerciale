package classPack;

public class ArticleVendue {
private	int id_article ;
private	String designation;
private	double prix ;
private	double quantite;
private	double remise ;
private	double taxe ;
	public int getId_article() {
		return id_article;
	}
	public ArticleVendue(int id_article, String designation, double prix, double quantite, double remise, double taxe) {
		this.id_article = id_article;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.remise = remise;
		this.taxe = taxe;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public double getRemise() {
		return remise;
	}
	public void setRemise(double remise) {
		this.remise = remise;
	}
	public double getTaxe() {
		return taxe;
	}
	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	
	

}
