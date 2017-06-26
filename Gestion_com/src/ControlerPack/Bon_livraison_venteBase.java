package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import classPack.Bon_livraison_vente;

public class Bon_livraison_venteBase{

	public Bon_livraison_venteModel mytablemodel;
	
	public Bon_livraison_venteBase()
	{
		
		mytablemodel=new Bon_livraison_venteModel(ConnectionDataBase.executeQuery("select * from Bon_livraison_vente"));

	}
public boolean AjoutBon_livraison_vente(Bon_livraison_vente f1)
{String req="INSERT INTO Bon_livraison_vente(ref_bon_livraison,id_doc_vente,id_facture) VALUES('"+f1.getRef_bon_livraison()+"',"+f1.getId_doc_vente()+","+f1.getId_facture()+")";
String rech="select max(id_bon_livraison) from Bon_livraison_vente where ref_bon_livraison='"+f1.getRef_bon_livraison()+"' and id_doc_vente="+f1.getId_doc_vente()+" and id_facture="+f1.getId_facture();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_bon_livraison(rs.getInt(1));
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


public int ModifierBon_livraison_vente(Bon_livraison_vente f1)
{String req="update  Bon_livraison_vente set ref_bon_livraison='"+f1.getRef_bon_livraison()+"',id_doc_vente="+f1.getId_doc_vente()+",id_facture="+f1.getId_facture()+" where id_bon_livraison="+f1.getId_bon_livraison();	
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
	rs=ConnectionDataBase.executeQuery("select * from Bon_livraison_vente");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Bon_livraison_vente where id_bon_livraison="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from Bon_livraison_vente where ref_bon_livraison='"+s+"'");
}

public void supprimerBon_livraison_vente(int id)
{String req="delete from Bon_livraison_vente where id_bon_livraison="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


