package ControlerPack;



import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Ligne_vente;








public class Ligne_venteBase{

	public Ligne_venteModel mytablemodel;
	
	public Ligne_venteBase()
	{
		
		mytablemodel=new Ligne_venteModel();


	}
public Ligne_vente AjoutLigne_vente(Ligne_vente f1)
{String req="INSERT INTO Ligne_vente(quantite,remise,prix,id_doc_vente,id_article) VALUES("+f1.getQuantite()+","+f1.getRemise()+","+f1.getPrix()+","+f1.getId_doc_vente()+","+f1.getarticle().getId_article()+")";
String rech="select max(id_ligneVente) from Ligne_vente where quantite="+f1.getQuantite()+" and remise="+f1.getRemise()+" and prix="+f1.getPrix()+" and id_doc_vente="+f1.getId_doc_vente()+" and id_article="+f1.getarticle().getId_article();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_ligneVente(rs.getInt(1));
	mytablemodel.AjouterLigne(f1);
	
	} catch (HeadlessException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	return f1;
}


public int ModifierLigne_vente(Ligne_vente f1)
{String req="update  Ligne_vente set quantite="+f1.getQuantite()+",remise="+f1.getRemise()+",id_doc_vente="+f1.getId_doc_vente()+",prix="+f1.getPrix()+",id_article="+f1.getarticle().getId_article()+" where id_ligneVente="+f1.getId_ligneVente();	
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
	rs=ConnectionDataBase.executeQuery("select * from Ligne_vente");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Ligne_vente where id_ligneVente="+id);
}

public void supprimerLigne_vente(int id)
{String req="delete from Ligne_vente where id_ligneVente="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


