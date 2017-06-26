package classPack;

public class Cloture {
	private int id_cloture;
	private  String date ;
	private double montant_ouverture;
	private double montant_fermeture;
	private int id_cassier ;
	
	
	public Cloture(int id_cloture, String date, double montant_ouverture, double montant_fermeture, int id_cassier) {
		super();
		this.id_cloture = id_cloture;
		this.date = date;
		this.montant_ouverture = montant_ouverture;
		this.montant_fermeture = montant_fermeture;
		this.id_cassier = id_cassier;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMontant_ouverture() {
		return montant_ouverture;
	}
	public void setMontant_ouverture(double montant_ouverture) {
		this.montant_ouverture = montant_ouverture;
	}
	public double getMontant_fermeture() {
		return montant_fermeture;
	}
	public void setMontant_fermeture(double montant_fermeture) {
		this.montant_fermeture = montant_fermeture;
	}
	public int getId_cassier() {
		return id_cassier;
	}
	public void setId_cassier(int id_cassier) {
		this.id_cassier = id_cassier;
	}
	public int getId_cloture() {
		return id_cloture;
	}
	public void setId_cloture(int id_cloture) {
		this.id_cloture = id_cloture;
	}
	

}
