package classPack;

public class Bon_livraison_vente {
private String reference ;
private int id_doc_vente;
private int id_factureV;
public Bon_livraison_vente(String reference, int id_doc_vente, int id_factureV) {
	super();
	this.reference = reference;
	this.id_doc_vente = id_doc_vente;
	this.id_factureV = id_factureV;
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
public int getId_factureV() {
	return id_factureV;
}
public void setId_factureV(int id_factureV) {
	this.id_factureV = id_factureV;
}

}
