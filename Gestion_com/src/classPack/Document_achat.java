package classPack;

public class Document_achat {
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
	public Document_achat(String dateDoccument, int id_fournisseur, int id_article) {
		super();
		this.dateDoccument = dateDoccument;
		this.id_fournisseur = id_fournisseur;
		this.id_article = id_article;
	}

}
