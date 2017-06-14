package classPack;

public class Document_vente {
	private String dateDoccument;
	private int id_client;
	private int id_article;
	public String getDateDoccument() {
		return dateDoccument;
	}
	public void setDateDoccument(String dateDoccument) {
		this.dateDoccument = dateDoccument;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public Document_vente(String dateDoccument, int id_client, int id_article) {
		super();
		this.dateDoccument = dateDoccument;
		this.id_client = id_client;
		this.id_article = id_article;
	}

}
