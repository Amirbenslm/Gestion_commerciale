package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import classPack.Reglement_achat;

public class Reglement_achatBase{

	public Reglement_achatModel mytablemodel;
	
	public Reglement_achatBase()
	{
		
		mytablemodel=new Reglement_achatModel(ConnectionDataBase.executeQuery("select * from Reglement_achat"));

	}
public boolean AjoutReglement_achat(Reglement_achat f1)
{String req="INSERT INTO Reglement_achat(montant,mode_paiement,echeance,id_doc_achat) VALUES("+f1.getMontant()+",'"+f1.getMode_payement()+"','"+f1.getEcheance()+"',"+f1.getId_doc_achat()+")";
String rech="select max(id_reg_achat) from Reglement_achat where montant="+f1.getMontant()+" and mode_paiement='"+f1.getMode_payement()+"' and echeance='"+f1.getEcheance()+"' and id_doc_achat="+f1.getId_doc_achat();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_reg_achat(rs.getInt(1));
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


public int ModifierReglement_achat(Reglement_achat f1)
{String req="update  Reglement_achat set montant="+f1.getMontant()+", mode_paiement='"+f1.getMode_payement()+"',echeance='"+f1.getEcheance()+"', id_doc_achat="+f1.getId_doc_achat()+" where id_reg_achat="+f1.getId_reg_achat();	
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
	rs=ConnectionDataBase.executeQuery("select * from Reglement_achat");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Reglement_achat where id_reg_achat="+id);
}
public ResultSet rechercheByModePayement(String s)
{
	return ConnectionDataBase.executeQuery("select * from Reglement_achat where mode_payement='"+s+"'");
}

public void supprimerReglement_achat(int id)
{String req="delete from Reglement_achat where id_reg_achat="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


