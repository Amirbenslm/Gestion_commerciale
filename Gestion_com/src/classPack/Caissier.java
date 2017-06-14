package classPack;

public class Caissier {
	private String cin;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String ville ;
	private String telephone;
	private String login ;
	private String pwd ;
	public Caissier(String cin, String nom, String prenom, String adresse, String ville, String telephone, String login,
			String pwd) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.login = login;
		this.pwd = pwd;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
