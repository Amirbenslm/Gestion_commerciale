package classPack;

public class Ticket {
	private int id_ticket;
	private String reference,date ;
	private int id_doc_vente;
	private int id_cassier;
	
	
	public Ticket(int id_ticket, String reference, String date, int id_doc_vente, int id_cassier) {
		super();
		this.id_ticket = id_ticket;
		this.reference = reference;
		this.setDate(date);
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
	public int getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
