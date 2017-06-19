package classPack;

public class Article {
	private int id_article;
	private String reference;
	private String designation;
	private float prix_unitaire;
	private float prixTTc;
	private float quantiteStock;
	private float quantiteMin;
	private String codeAbarre;
	private int id_famille;
	private int id_taxe ;
	
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public Article(int id_article, String reference, String designation, float prix_unitaire, float prixTTc,
			float qte_stock, float qte_min, String codeAbarre, int id_famille, int id_taxe) {
		super();
		this.id_article = id_article;
		this.reference = reference;
		this.designation = designation;
		this.prix_unitaire=prix_unitaire;
		this.prixTTc = prixTTc;
		this.quantiteStock = qte_stock;
		this.quantiteMin = qte_min;
		this.codeAbarre = codeAbarre;
		this.id_famille = id_famille;
		this.id_taxe = id_taxe;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrixTTc() {
		return prixTTc;
	}
	public void setPrixTTc(float prixTTc) {
		this.prixTTc = prixTTc;
	}
	public float getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(float quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public float getQuantiteMin() {
		return quantiteMin;
	}
	public void setQuantiteMin(float quantiteMin) {
		this.quantiteMin = quantiteMin;
	}
	public String getCodeAbarre() {
		return codeAbarre;
	}
	public void setCodeAbarre(String codeAbarre) {
		this.codeAbarre = codeAbarre;
	}
	public int getId_famille() {
		return id_famille;
	}
	public void setId_famille(int id_famille) {
		this.id_famille = id_famille;
	}
	public int getId_taxe() {
		return id_taxe;
	}
	public void setId_taxe(int id_taxe) {
		this.id_taxe = id_taxe;
	}
	public float getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	

}
