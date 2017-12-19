package classPack;

public class Reglement_achat {
	private  int id_reg_achat ;
	private double montant;
	String date_reglement;
	private String mode_payement ;
	private String echeance ;
	private int id_doc_achat;
	
	
	
	public Reglement_achat(int id_reg_achat, double montant, String date_reglement, String mode_payement,
			String echeance, int id_doc_achat) {
		this.id_reg_achat = id_reg_achat;
		this.montant = montant;
		this.date_reglement = date_reglement;
		this.mode_payement = mode_payement;
		this.echeance = echeance;
		this.id_doc_achat = id_doc_achat;
	}
	public String getDate_reglement() {
		return date_reglement;
	}
	public void setDate_reglement(String date_reglement) {
		this.date_reglement = date_reglement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getMode_payement() {
		return mode_payement;
	}
	public void setMode_payement(String mode_payement) {
		this.mode_payement = mode_payement;
	}
	public String getEcheance() {
		return echeance;
	}
	public void setEcheance(String echeance) {
		this.echeance = echeance;
	}
	public int getId_doc_achat() {
		return id_doc_achat;
	}
	public void setId_doc_achat(int id_doc_achat) {
		this.id_doc_achat = id_doc_achat;
	}
	public int getId_reg_achat() {
		return id_reg_achat;
	}
	public void setId_reg_achat(int id_reg_achat) {
		this.id_reg_achat = id_reg_achat;
	}
	

}
