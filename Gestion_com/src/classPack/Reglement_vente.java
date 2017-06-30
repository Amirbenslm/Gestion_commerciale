package classPack;

public class Reglement_vente {
	private int id_reg_vente ;
	private double montant;
	private String mode_payement ;
	private String echeance ;
	private int id_doc_vente;
	
	
	public Reglement_vente(int id_reg_vente, double montant, String mode_payement, String echeance,
			int id_doc_vente) {
		super();
		this.id_reg_vente = id_reg_vente;
		this.montant = montant;
		this.mode_payement = mode_payement;
		this.echeance = echeance;
		this.id_doc_vente = id_doc_vente;
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
	public int getId_doc_vente() {
		return id_doc_vente;
	}
	public void setId_doc_vente(int id_doc_vente) {
		this.id_doc_vente = id_doc_vente;
	}
	public int getId_reg_vente() {
		return id_reg_vente;
	}
	public void setId_reg_vente(int id_reg_vente) {
		this.id_reg_vente = id_reg_vente;
	}
	

}
