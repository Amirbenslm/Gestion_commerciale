package classPack;

public class Facture {
	private int id_facture;
	private String reference ;
	private float retour_source;
	private float taxe_fiscale;
	private float fodec ;
	private int id_doc_vente;
	
	public Facture(int id_facture, String reference, float retour_source, float taxe_fiscale, float fodec,
			int id_doc_vente) {
		super();
		this.setId_facture(id_facture);
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
	public float getRetour_source() {
		return retour_source;
	}
	public void setRetour_source(float retour_source) {
		this.retour_source = retour_source;
	}
	public float getTaxe_fiscale() {
		return taxe_fiscale;
	}
	public void setTaxe_fiscale(float taxe_fiscale) {
		this.taxe_fiscale = taxe_fiscale;
	}
	public float getFodec() {
		return fodec;
	}
	public void setFodec(float fodec) {
		this.fodec = fodec;
	}
	public int getId_doc_vente() {
		return id_doc_vente;
	}
	public void setId_doc_vente(int id_doc_vente) {
		this.id_doc_vente = id_doc_vente;
	}
	public int getId_facture() {
		return id_facture;
	}
	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}
}
