package classPack;

public class Ligne_vente {
	private int id_ligneVente ;
	private float quantite;
	private float remise;
	private double prix  ;
	private int id_doc_vente;
	private Article article ;
	
	public Ligne_vente(int id_ligneVente, float quantite, float remise, double d, int id_doc_vente, Article article) {
		this.id_ligneVente = id_ligneVente;
		this.quantite = quantite;
		this.remise = remise;
		this.prix = d;
		this.id_doc_vente = id_doc_vente;
		this.article = article;
	}
	public float getQuantite() {
		return quantite;
	}
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	public float getRemise() {
		return remise;
	}
	public void setRemise(float remise) {
		this.remise = remise;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getId_doc_vente() {
		return id_doc_vente;
	}
	public void setId_doc_vente(int id_doc_vente) {
		this.id_doc_vente = id_doc_vente;
	}
	public Article getarticle() {
		return article;
	}
	public void setarticle(Article article) {
		this.article = article;
	}
	public int getId_ligneVente() {
		return id_ligneVente;
	}
	public void setId_ligneVente(int id_ligneVente) {
		this.id_ligneVente = id_ligneVente;
	}
}
