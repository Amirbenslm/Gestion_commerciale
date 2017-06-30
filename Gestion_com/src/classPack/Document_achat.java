package classPack;

public class Document_achat {
	private int id_documentA ;
	private String dateDoccument;
	private int id_article;
	private int id_fournisseur;
	public String getDateDoccument() {
		return dateDoccument;
	}
	public void setDateDoccument(String dateDoccument) {
		this.dateDoccument = dateDoccument;
	}
	public int getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	
	public Document_achat(int id_documentA, String dateDoccument, int id_article, int id_fournisseur) {
		super();
		this.id_documentA = id_documentA;
		this.dateDoccument = dateDoccument;
		this.id_article = id_article;
		this.id_fournisseur = id_fournisseur;
	}
	public int getId_documentA() {
		return id_documentA;
	}
	public void setId_documentA(int id_documentA) {
		this.id_documentA = id_documentA;
	}

}
