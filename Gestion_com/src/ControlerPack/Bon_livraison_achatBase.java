package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import classPack.Bon_livraison_achat;

public class Bon_livraison_achatBase{

	public Bon_livraison_achatModel mytablemodel;
	
	public Bon_livraison_achatBase()
	{
		
		mytablemodel=new Bon_livraison_achatModel(ConnectionDataBase.executeQuery("select * from Bon_livraison_achat"));

	}
public boolean AjoutBon_livraison_achat(Bon_livraison_achat f1)
{String req="INSERT INTO Bon_livraison_achat(ref_bon_livraisonA,id_doc_achat,id_factureA) VALUES('"+f1.getReference()+"',"+f1.getId_doc_achat()+","+f1.getId_factureA()+")";
String rech="select max(id_bon_livraisonA) from Bon_livraison_achat where ref_bon_livraisonA='"+f1.getReference()+"' and id_doc_achat="+f1.getId_doc_achat()+" and id_factureA="+f1.getId_factureA();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_bon_livraissonA(rs.getInt(1));
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


public int ModifierBon_livraison_achat(Bon_livraison_achat f1)
{String req="update  Bon_livraison_achat set ref_bon_livraisonA='"+f1.getReference()+"',id_doc_achat="+f1.getId_doc_achat()+",id_factureA="+f1.getId_factureA()+" where id_bon_livraisonA="+f1.getId_bon_livraissonA();	
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
	rs=ConnectionDataBase.executeQuery("select * from Bon_livraison_achat");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Bon_livraison_achat where id_bon_livraisonA="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from Bon_livraison_achat where ref_bon_livraisonA='"+s+"'");
}

public void supprimerBon_livraison_achat(int id)
{String req="delete from Bon_livraison_achat where id_bon_livraisonA="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


