package classPack;

public class Bon_Commande {
private String reference ;
private int id_bon_livraisonA;
private int id_doc_achat ;
public Bon_Commande(String reference, int id_bon_livraisonA, int id_doc_achat) {
	super();
	this.reference = reference;
	this.id_bon_livraisonA = id_bon_livraisonA;
	this.id_doc_achat = id_doc_achat;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public int getId_bon_livraisonA() {
	return id_bon_livraisonA;
}
public void setId_bon_livraisonA(int id_bon_livraisonA) {
	this.id_bon_livraisonA = id_bon_livraisonA;
}
public int getId_doc_achat() {
	return id_doc_achat;
}
public void setId_doc_achat(int id_doc_achat) {
	this.id_doc_achat = id_doc_achat;
}

}
