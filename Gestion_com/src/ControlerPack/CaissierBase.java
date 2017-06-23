package ControlerPack;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import classPack.Caissier;
import classPack.Fournisseur;

public class CaissierBase{
	
	Statement st;
	Connection con;
	public CaissierModel mytablemodel;
	
	public CaissierBase()
	{
		
		mytablemodel=new CaissierModel(ConnectionDataBase.executeQuery("select * from caissier"));


	}
public boolean AjoutCaissier(Caissier f1)
{String req="INSERT INTO caissier(ncin,nom,prenom,adresse,ville,telephone,login,pwd) VALUES('"+f1.getNcin()+"','"+f1.getNom()+"','"+f1.getPrenom()+"','"+f1.getAdresse()+"','"+f1.getVille()+"','"+f1.getTelephone()+"','"+f1.getLogin()+"','"+f1.getPwd()+"')";
String exsist="select * from caissier where ncin='"+f1.getNcin()+"'"+"and nom='"+f1.getNom()+"'"+"and prenom='"+f1.getPrenom()+"'"+"and adresse='"+f1.getAdresse()+"'"+"and telephone='"+f1.getTelephone()+"'"+"and login='"+f1.getLogin()+"'"+"and pwd='"+f1.getPwd()+"'";
String rech="select max(id_caissier)  from caissier where ncin='"+f1.getNcin()+"'"+"and nom='"+f1.getNom()+"'"+"and prenom='"+f1.getPrenom()+"'"+"and adresse='"+f1.getAdresse()+"'"+"and telephone='"+f1.getTelephone()+"'"+"and login='"+f1.getLogin()+"'"+"and pwd='"+f1.getPwd()+"'";

ResultSet existe=ConnectionDataBase.executeQuery(exsist);
try {
	if (existe.next())
		{JOptionPane.showMessageDialog(null," existe un Caissier deja de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
		return false;
		}
	else {ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_caissier(rs.getInt(1));
	mytablemodel.AjouterLigne(f1);
	}
	} catch (HeadlessException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	return true;
}


public int ModifierCAissier(Caissier f1)
{String req="update  caissier set ncin='"+f1.getNcin()+"', nom='"+f1.getNom()+"',prenom='"+f1.getPrenom()+"',adresse='"+f1.getAdresse()+"',ville='"+f1.getVille()+"',telephone='"+f1.getTelephone()+"',login='"+f1.getLogin()+"',pwd='"+f1.getPwd()+"' where id_caissier="+f1.getId_caissier() ;	
 int x=ConnectionDataBase.executeUpdate(req);
mytablemodel.ModifierLigne(f1);
 /*if (x>0)
	 System.out.println("Done MAJ");
 else
	 System.out.println("Ereeure MAJ");
 */return x;	
}
public ResultSet affiche()
{ResultSet rs = null;
	rs=ConnectionDataBase.executeQuery("select * from caissier");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from caissier where id_caissier="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from caissier where nom='"+s+"'");
}
public ResultSet rechercheByVille(String s)
{
	return ConnectionDataBase.executeQuery("select * from caissier where ville='"+s+"'");
}
public ResultSet rechercheByNCIN(String s)
{
	return ConnectionDataBase.executeQuery("select * from caissier where ncin='"+s+"'");
}
public void supprimerCaissier(int id)
{String req="delete from caissier where id_caissier="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}
