package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import classPack.Bon_livraison_vente;
import classPack.Devis;

public class DevisBase{

	public DevisModel mytablemodel;
	
	public DevisBase()
	{
		
		mytablemodel=new DevisModel(ConnectionDataBase.executeQuery("select * from devis"));

	}
public boolean AjoutDevis(Devis f1)
{String req="INSERT INTO devis(ref_devis,id_doc_vente) VALUES('"+f1.getReference()+"',"+f1.getId_doc_vente()+/*","+f1.getId_bon_livraison()+*/")";
String rech="select max(id_devis) from devis where ref_devis='"+f1.getReference()+"' and id_doc_vente="+f1.getId_doc_vente();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_devis(rs.getInt(1));
	System.out.println("iddevis:"+rs.getInt(1));
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


public int ModifierDevis(Devis f1)
{String req="update  Devis set ref_devis='"+f1.getReference()+"',id_doc_vente="+f1.getId_doc_vente()+",id_bon_livraison="+f1.getId_bon_livraison()+" where id_devis="+f1.getId_devis();	
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
	rs=ConnectionDataBase.executeQuery("select * from devis");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from devis where id_devis="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from devis where ref_devis='"+s+"'");
}

public void supprimerDevis(int id)
{String req="delete from devis where id_devis="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


