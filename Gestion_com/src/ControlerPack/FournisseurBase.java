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

import classPack.Client;
import classPack.Fournisseur;

public class FournisseurBase{
	

	public FournisseurModel mytablemodel;
	
	public FournisseurBase()
	{
		
		mytablemodel=new FournisseurModel(ConnectionDataBase.executeQuery("select * from fournisseur"));


	}
public boolean AjoutFournisseur(Fournisseur f1)
{String req="INSERT INTO fournisseur(ref_fournisseur,raison_social,adresse,ville,matricule_fiscale,num_reg_commercial,num_tel) VALUES('"+f1.getReference()+"','"+f1.getRason_social()+"','"+f1.getAdresse()+"','"+f1.getVille()+"','"+f1.getMatricule_fiscale()+"','"+f1.getNum_reg_commerciale()+"','"+f1.getNum_tel()+"')";
String exsist="select * from fournisseur where ref_fournisseur='"+f1.getReference()+"'"+"and raison_social='"+f1.getRason_social()+"'"+"and adresse='"+f1.getAdresse()+"'"+"and matricule_fiscale='"+f1.getMatricule_fiscale()+"'"+"and num_reg_commercial='"+f1.getNum_reg_commerciale()+"'"+"and num_tel='"+f1.getNum_tel()+"'";
String rech="select max(id_fournisseur) from fournisseur where ref_fournisseur='"+f1.getReference()+"'"+"and raison_social='"+f1.getRason_social()+"'"+"and adresse='"+f1.getAdresse()+"'"+"and matricule_fiscale='"+f1.getMatricule_fiscale()+"'"+"and num_reg_commercial='"+f1.getNum_reg_commerciale()+"'"+"and num_tel='"+f1.getNum_tel()+"'";

ResultSet existe=ConnectionDataBase.executeQuery(exsist);
try {
	if (existe.next())
		{JOptionPane.showMessageDialog(null," existe un fournisseur deja de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
		return false;
		}
	else {ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId(rs.getInt(1));
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


public int ModifierFournisseur(Fournisseur f1)
{String req="update  fournisseur set ref_fournisseur='"+f1.getReference()+"',raison_social ='"+f1.getRason_social()+"',adresse='"+f1.getAdresse()+"',ville='"+f1.getVille()+"',matricule_fiscale='"+f1.getMatricule_fiscale()+"',num_reg_commercial='"+f1.getNum_reg_commerciale()+"',num_tel='"+f1.getNum_tel()+"' where id_fournisseur="+f1.getId();	
 int x=ConnectionDataBase.executeUpdate(req);
mytablemodel.ModifierLigne(f1);
 if (x>0)
	 System.out.println("Done MAJ");
 else
	 System.out.println("Ereeure MAJ");
 return x;	
}
public ResultSet affiche()
{ResultSet rs = null;
	rs=ConnectionDataBase.executeQuery("select * from fournisseur");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from fournisseur where id_fournisseur="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from fournisseur where ref_fournisseur='"+s+"'");
}
public ResultSet rechercheByVille(String s)
{
	return ConnectionDataBase.executeQuery("select * from fournisseur where ville='"+s+"'");
}
 
public void supprimerFourisseur(int l)
{String req="delete from fournisseur where id_fournisseur="+mytablemodel.data.get(l).getId();
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(l);
}

public Fournisseur getFournisseur(int id) {
	// TODO Auto-generated method stub
	return mytablemodel.getFournisseur(id);
}



}
