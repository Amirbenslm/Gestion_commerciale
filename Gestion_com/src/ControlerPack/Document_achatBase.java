package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Document_achat;




public class Document_achatBase{

	public Document_achatModel mytablemodel;
	
	public Document_achatBase()
	{
		
		mytablemodel=new Document_achatModel(ConnectionDataBase.executeQuery("select * from Document_achat"));

	}
public boolean AjoutDocument_achat(Document_achat f1)
{
	String req="INSERT INTO Document_achat(date_doc_achat,id_fournisseur) VALUES('"+f1.getDateDoccument()+"',"+f1.getId_fournisseur()+")";
String rech="select max(id_documentA) from Document_achat where date_doc_achat='"+f1.getDateDoccument()+"' and id_fournisseur="+f1.getId_fournisseur();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_documentA(rs.getInt(1));
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


public int ModifierDocument_achat(Document_achat f1)
{String req="update  Document_achat set date_doc_achat='"+f1.getDateDoccument()+"', id_fournisseur="+f1.getId_fournisseur()+" where id_documentA="+f1.getId_documentA();	
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
	rs=ConnectionDataBase.executeQuery("select * from Document_achat");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Document_achat where id_documentA="+id);
}

public void supprimerDocument_achat(int id)
{String req="delete from Document_achat where id_documentA="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


