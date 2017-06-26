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

import classPack.Facture;



public class FactureBase{

	public FactureModel mytablemodel;
	
	public FactureBase()
	{
		
		mytablemodel=new FactureModel(ConnectionDataBase.executeQuery("select * from facture"));


	}
public boolean AjoutFacture(Facture f1)
{String req="INSERT INTO Facture(ref_facture,retour_source,t_fiscale,fodec,id_doc_vente) VALUES('"+f1.getReference()+"','"+f1.getRetour_source()+"','"+f1.getTaxe_fiscale()+"','"+f1.getFodec()+"','"+f1.getId_doc_vente()+"')";
String exsist="select * from Facture where ref_facture='"+f1.getReference()+"'"+"and retour_source='"+f1.getRetour_source()+"'"+"and t_fiscale='"+f1.getTaxe_fiscale()+"'"+"and fodec='"+f1.getFodec()+"'"+"and id_doc_vente='"+f1.getId_doc_vente()+"'";
String rech="select max(id_facture) from facture where ref_facture='"+f1.getReference()+"'"+"and retour_source='"+f1.getRetour_source()+"'"+"and t_fiscale='"+f1.getTaxe_fiscale()+"'"+"and fodec='"+f1.getFodec()+"'"+"and id_doc_vente='"+f1.getId_doc_vente()+"'";


try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_facture(rs.getInt(1));
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


public int ModifierFacture(Facture f1)
{String req="update  facture set ref_facture='"+f1.getReference()+"',retour_source ='"+f1.getRetour_source()+"',t_fiscale='"+f1.getTaxe_fiscale()+"',fodec='"+f1.getFodec()+"',id_doc_vente='"+f1.getId_doc_vente()+"' where id_facture="+f1.getId_facture();	
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
	rs=ConnectionDataBase.executeQuery("select * from facture");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from facture where id_facture="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from facture where ref_facture='"+s+"'");
}
public ResultSet rechercheByretour_source(String s)
{
	return ConnectionDataBase.executeQuery("select * from facture where retour_source='"+s+"'");
}
public void supprimerFacture(int id)
{String req="delete from facture where id_facture="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


