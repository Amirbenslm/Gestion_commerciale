package classPack;

public class Reglement_achat {
	private double montant;
	private String mode_payement ;
	private String echeance ;
	private String id_doc_achat;
	
	public Reglement_achat(double montant, String mode_payement, String echeance, String id_doc_achat) {
		super();
		this.montant = montant;
		this.mode_payement = mode_payement;
		this.echeance = echeance;
		this.id_doc_achat = id_doc_achat;
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
	public String getId_doc_achat() {
		return id_doc_achat;
	}
	public void setId_doc_achat(String id_doc_achat) {
		this.id_doc_achat = id_doc_achat;
	}
	

}
