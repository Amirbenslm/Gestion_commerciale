package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Document_vente;


public class Document_venteBase{

	public Document_venteModel mytablemodel;
	
	public Document_venteBase()
	{
		
		mytablemodel=new Document_venteModel(ConnectionDataBase.executeQuery("select * from Document_vente"));

	}
public boolean AjoutDocument_vente(Document_vente f1)
{String req="INSERT INTO Document_vente(date_documentV,id_client) VALUES('"+f1.getDate_doccumentV()+"',"+f1.getId_client()+")";
String rech="select max(id_documentV) from Document_vente where date_documentV='"+f1.getDate_doccumentV()+"' and id_client="+f1.getId_client();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_documentV(rs.getInt(1));
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


public int ModifierDocument_vente(Document_vente f1)
{String req="update  Document_vente set date_documentV='"+f1.getDate_doccumentV()+"', id_client="+f1.getId_client()+" where id_documentV="+f1.getId_documentV();	
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
	rs=ConnectionDataBase.executeQuery("select * from Document_vente");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Document_vente where id_documentV="+id);
}

public void supprimerDocument_vente(int id)
{String req="delete from Document_vente where id_documentV="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


