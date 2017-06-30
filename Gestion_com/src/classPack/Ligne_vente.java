package classPack;

public class Ligne_vente {
	private int id_ligneVente ;
	private float quantite;
	private float remise;
	private float prix  ;
	private int id_doc_vente;
	private int id_article ;
	
	public Ligne_vente(int id_ligneVente, float quantite, float remise, float prix, int id_doc_vente, int id_article) {
		this.id_ligneVente = id_ligneVente;
		this.quantite = quantite;
		this.remise = remise;
		this.prix = prix;
		this.id_doc_vente = id_doc_vente;
		this.id_article = id_article;
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
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getId_doc_vente() {
		return id_doc_vente;
	}
	public void setId_doc_vente(int id_doc_vente) {
		this.id_doc_vente = id_doc_vente;
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public int getId_ligneVente() {
		return id_ligneVente;
	}
	public void setId_ligneVente(int id_ligneVente) {
		this.id_ligneVente = id_ligneVente;
	}
}
