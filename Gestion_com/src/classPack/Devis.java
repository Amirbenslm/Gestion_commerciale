package classPack;

public class Devis {
	private int id_devis;
	private String reference;
	private int id_doc_vente;
	private int id_bon_livraison;
	
	public Devis(int id_devis, String reference, int id_doc_vente, int id_bon_livraison) {
		super();
		this.id_devis = id_devis;
		this.reference = reference;
		this.id_doc_vente = id_doc_vente;
		this.id_bon_livraison = id_bon_livraison;
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
	public int getId_bon_livraison() {
		return id_bon_livraison;
	}
	public void setId_bon_livraison(int id_bon_livraison) {
		this.id_bon_livraison = id_bon_livraison;
	}
	public int getId_devis() {
		return id_devis;
	}
	public void setId_devis(int id_devis) {
		this.id_devis = id_devis;
	}
	

}
