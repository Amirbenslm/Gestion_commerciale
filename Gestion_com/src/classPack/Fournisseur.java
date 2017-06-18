package classPack;

public class Fournisseur {
private int id ;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String reference;
private String rason_social;
private String adresse;
private String ville ;
private String matricule_fiscale;
private String num_reg_commerciale ;
private String num_tel ;



public Fournisseur(int id, String reference, String rason_social, String adresse, String ville,
		String matricule_fiscale, String num_reg_commerciale, String num_tel) {
	super();
	this.id = id;
	this.reference = reference;
	this.rason_social = rason_social;
	this.adresse = adresse;
	this.ville = ville;
	this.matricule_fiscale = matricule_fiscale;
	this.num_reg_commerciale = num_reg_commerciale;
	this.num_tel = num_tel;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public String getRason_social() {
	return rason_social;
}
public void setRason_social(String rason_social) {
	this.rason_social = rason_social;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getMatricule_fiscale() {
	return matricule_fiscale;
}
public void setMatricule_fiscale(String matricule_fiscale) {
	this.matricule_fiscale = matricule_fiscale;
}
public String getNum_reg_commerciale() {
	return num_reg_commerciale;
}
public void setNum_reg_commerciale(String num_reg_commerciale) {
	this.num_reg_commerciale = num_reg_commerciale;
}
public String getNum_tel() {
	return num_tel;
}
public void setNum_tel(String num_tel) {
	this.num_tel = num_tel;
}


}
