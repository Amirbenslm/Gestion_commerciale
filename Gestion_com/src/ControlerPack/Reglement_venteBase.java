package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Reglement_vente;


public class Reglement_venteBase{

	public Reglement_venteModel mytablemodel;
	
	public Reglement_venteBase()
	{
		
		mytablemodel=new Reglement_venteModel(ConnectionDataBase.executeQuery("select * from Reglement_vente"));

	}
public boolean AjoutReglement_vente(Reglement_vente f1)
{String req="INSERT INTO Reglement_vente(montant,mode_paiement,echeance,id_doc_vente) VALUES("+f1.getMontant()+",'"+f1.getMode_payement()+"','"+f1.getEcheance()+"',"+f1.getId_doc_vente()+")";
String rech="select max(id_reg_vente) from Reglement_vente where montant="+f1.getMontant()+" and mode_paiement='"+f1.getMode_payement()+"' and echeance='"+f1.getEcheance()+"' and id_doc_vente="+f1.getId_doc_vente();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_reg_vente(rs.getInt(1));
	mytablemodel.AjouterLigne(f1);
	
	} catch (HeadlessException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	return true;
}


public int ModifierReglement_vente(Reglement_vente f1)
{String req="update  Reglement_vente set montant="+f1.getMontant()+", mode_paiement='"+f1.getMode_payement()+"',echeance='"+f1.getEcheance()+"', id_doc_vente="+f1.getId_doc_vente()+" where id_reg_vente="+f1.getId_reg_vente();	
 int x=ConnectionDataBase.executeUpdate(req);

 if (x>0)
	 {System.out.println("Done MAJ");
 mytablemodel.ModifierLigne(f1);
	 }else
	 System.out.println("Ereeure MAJ");
 return x;	
}
public ResultSet affiche()
{ResultSet rs = null;
	rs=ConnectionDataBase.executeQuery("select * from Reglement_vente");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Reglement_vente where id_reg_vente="+id);
}
public ResultSet rechercheByModePayement(String s)
{
	return ConnectionDataBase.executeQuery("select * from Reglement_vente where mode_payement='"+s+"'");
}

public void supprimerReglement_vente(int id)
{String req="delete from Reglement_vente where id_reg_vente="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


