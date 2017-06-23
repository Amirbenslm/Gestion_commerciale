package classPack;

public class Facture_Achat {
	private int	id_factureAchat; 
	private String reference ;
	private float retour_source;
	private float taxe_fiscale;
	private float fodec ;
	private int id_doc_achat;
	
	public Facture_Achat(int id_factureAchat, String reference, float retour_source, float taxe_fiscale, float fodec,
			int id_doc_achat) {
		super();
		this.id_factureAchat = id_factureAchat;
		this.reference = reference;
		this.retour_source = retour_source;
		this.taxe_fiscale = taxe_fiscale;
		this.fodec = fodec;
		this.id_doc_achat = id_doc_achat;
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
	public int getId_docAchat() {
		return id_doc_achat;
	}
	public void setId_docAchat(int id_doc_achat) {
		this.id_doc_achat = id_doc_achat;
	}
	public int getId_factureAchat() {
		return id_factureAchat;
	}
	public void setId_factureAchat(int id_factureAchat) {
		this.id_factureAchat = id_factureAchat;
	}
}
