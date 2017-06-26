package classPack;

public class Bon_livraison_vente {
	private int id_bon_livraison;
private String ref_bon_livraison ;
private int id_doc_vente;
private int id_facture;

public Bon_livraison_vente(int id_bon_livraison, String ref_bon_livraison, int id_doc_vente, int id_facture) {
	super();
	this.id_bon_livraison = id_bon_livraison;
	this.ref_bon_livraison = ref_bon_livraison;
	this.id_doc_vente = id_doc_vente;
	this.id_facture = id_facture;
}

public int getId_bon_livraison() {
	return id_bon_livraison;
}

public void setId_bon_livraison(int id_bon_livraison) {
	this.id_bon_livraison = id_bon_livraison;
}

public String getRef_bon_livraison() {
	return ref_bon_livraison;
}

public void setRef_bon_livraison(String ref_bon_livraison) {
	this.ref_bon_livraison = ref_bon_livraison;
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
