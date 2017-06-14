package classPack;

public class Article {
	private String reference;
	private String designation;
	private float prixUnitaire;
	private float prixTTc;
	private int quantiteStock;
	private int quantiteMin;
	private String codeAbarre;
	private int id_famille;
	private int id_taxe ;
	public Article(String reference, String designation, float prixUnitaire, float prixTTc, int quantiteStock,
			int quantiteMin, String codeAbarre, int id_famille, int id_taxe) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.prixTTc = prixTTc;
		this.quantiteStock = quantiteStock;
		this.quantiteMin = quantiteMin;
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
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public float getPrixTTc() {
		return prixTTc;
	}
	public void setPrixTTc(float prixTTc) {
		this.prixTTc = prixTTc;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public int getQuantiteMin() {
		return quantiteMin;
	}
	public void setQuantiteMin(int quantiteMin) {
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
	

}
