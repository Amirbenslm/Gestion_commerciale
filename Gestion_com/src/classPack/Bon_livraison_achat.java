package classPack;

public class Bon_livraison_achat {
private String reference ;
private int id_doc_achat;
private int id_factureA;
public Bon_livraison_achat(String reference, int id_doc_achat, int id_factureA) {
	super();
	this.reference = reference;
	this.id_doc_achat = id_doc_achat;
	this.id_factureA = id_factureA;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public int getId_doc_achat() {
	return id_doc_achat;
}
public void setId_doc_achat(int id_doc_achat) {
	this.id_doc_achat = id_doc_achat;
}
public int getId_factureA() {
	return id_factureA;
}
public void setId_factureA(int id_factureA) {
	this.id_factureA = id_factureA;
}

}
