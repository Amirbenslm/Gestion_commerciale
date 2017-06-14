package classPack;

public class Ticket {
	private String reference ;
	private int id_doc_vente;
	private int id_cassier;
	public Ticket(String reference, int id_doc_vente, int id_cassier) {
		super();
		this.reference = reference;
		this.id_doc_vente = id_doc_vente;
		this.id_cassier = id_cassier;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public int getId_doc_vente() {
		return id_doc_vente;
	}
	public void setId_doc_vente(int id_doc_vente) {
		this.id_doc_vente = id_doc_vente;
	}
	public int getId_cassier() {
		return id_cassier;
	}
	public void setId_cassier(int id_cassier) {
		this.id_cassier = id_cassier;
	}
	
}
