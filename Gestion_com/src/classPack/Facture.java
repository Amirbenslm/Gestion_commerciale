package classPack;

public class Facture {
	private String reference ;
	private String retour_source;
	private String taxe_fiscale;
	private String fodec ;
	private int id_doc_vente;
	public Facture(String reference, String retour_source, String taxe_fiscale, String fodec, int id_doc_vente) {
		super();
		this.reference = reference;
		this.retour_source = retour_source;
		this.taxe_fiscale = taxe_fiscale;
		this.fodec = fodec;
		this.id_doc_vente = id_doc_vente;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getRetour_source() {
		return retour_source;
	}
	public void setRetour_source(String retour_source) {
		this.retour_source = retour_source;
	}
	public String getTaxe_fiscale() {
		return taxe_fiscale;
	}
	public void setTaxe_fiscale(String taxe_fiscale) {
		this.taxe_fiscale = taxe_fiscale;
	}
	public String getFodec() {
		return fodec;
	}
	public void setFodec(String fodec) {
		this.fodec = fodec;
	}
	public int getId_doc_vente() {
		return id_doc_vente;
	}
	public void setId_doc_vente(int id_doc_vente) {
		this.id_doc_vente = id_doc_vente;
	}
}
