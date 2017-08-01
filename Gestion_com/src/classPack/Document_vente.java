package classPack;

public class Document_vente {
	private int id_documentV ;
	private String date_doccumentV;
	private String type_doc;
	private int id_client;
	
	
	public Document_vente(int id_documentV, String date_doccumentV, String type_doc, int id_client) {
		this.id_documentV = id_documentV;
		this.date_doccumentV = date_doccumentV;
		this.type_doc = type_doc;
		this.id_client = id_client;
	}
	public int getId_documentV() {
		return id_documentV;
	}
	public void setId_documentV(int id_documentV) {
		this.id_documentV = id_documentV;
	}
	public String getDate_doccumentV() {
		return date_doccumentV;
	}
	public void setDate_doccumentV(String date_doccumentV) {
		this.date_doccumentV = date_doccumentV;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getType_doc() {
		return type_doc;
	}
	public void setType_doc(String type_doc) {
		this.type_doc = type_doc;
	}


}