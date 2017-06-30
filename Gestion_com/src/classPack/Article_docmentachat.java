package classPack;

public class Article_docmentachat {
	private int id_article_docAchat,id_article,id_docAchat ;

	public Article_docmentachat(int id_article_docAchat, int id_article, int id_docAchat) {
		this.id_article_docAchat = id_article_docAchat;
		this.id_article = id_article;
		this.id_docAchat = id_docAchat;
	}

	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public int getId_docAchat() {
		return id_docAchat;
	}

	public void setId_docAchat(int id_docAchat) {
		this.id_docAchat = id_docAchat;
	}

	public int getId_article_docAchat() {
		return id_article_docAchat;
	}

	public void setId_article_docAchat(int id_article_docAchat) {
		this.id_article_docAchat = id_article_docAchat;
	}

}
