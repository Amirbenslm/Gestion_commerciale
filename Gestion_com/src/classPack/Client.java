package classPack;

public class Client {
	private int idclient;
	private String nom;
	private String prenom ;
	private String cin ;
	private String dateclient ;
	private String adresse ;
	private String ville ;
	private String matricule_fiscale ;
	private String num_reg_commerciale ;
	private String tel ;
	private String email ;
	
	public Client(int idclient, String nom, String prenom, String cin, String dateclient, String adresse, String ville,
			String matricule_fiscale, String num_reg_commerciale, String tel, String email) {
		super();
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.dateclient = dateclient;
		this.adresse = adresse;
		this.ville = ville;
		this.matricule_fiscale = matricule_fiscale;
		this.num_reg_commerciale = num_reg_commerciale;
		this.tel = tel;
		this.email = email;
	}
	public int getIdClient() {
		return idclient;
	}
	public void setIdClient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getDateclient() {
		return dateclient;
	}
	public void setDateclient(String dateclient) {
		this.dateclient = dateclient;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
