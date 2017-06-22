package classPack;

public class Caissier {
	private int id_caissier;
	private String ncin;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String ville ;
	private String telephone;
	private String login ;
	private String pwd ;
	
	public int getId_caissier() {
		return id_caissier;
	}
	public void setId_caissier(int id_caissier) {
		this.id_caissier = id_caissier;
	}
	
	public Caissier(int id_caissier, String ncin, String nom, String prenom, String adresse, String ville,
			String telephone, String login, String pwd) {
		super();
		this.id_caissier = id_caissier;
		this.ncin = ncin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.login = login;
		this.pwd = pwd;
	}
	
	public String getNcin() {
		return ncin;
	}
	public void setNcin(String ncin) {
		this.ncin = ncin;
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
