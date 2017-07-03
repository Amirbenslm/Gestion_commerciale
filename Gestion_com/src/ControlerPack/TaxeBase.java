package ControlerPack;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Taxe;

public class TaxeBase{

	public TaxeModel mytablemodel;
	
	public TaxeBase()
	{
		
		mytablemodel=new TaxeModel(ConnectionDataBase.executeQuery("select * from Taxe"));


	}
public boolean AjoutTaxe(Taxe f1)
{String req="INSERT INTO Taxe(libelle,taux) VALUES('"+f1.getLibelle()+"',"+f1.getTaux()+")";
String rech="select max(id_taxe) from taxe where libelle='"+f1.getLibelle()+"'"+"and taux="+f1.getTaux();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_taxe(rs.getInt(1));
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


public int ModifierTaxe(Taxe f1)
{String req="update  Taxe set libelle='"+f1.getLibelle()+"',taux="+f1.getTaux()+" where id_taxe="+f1.getId_taxe();	
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
	rs=ConnectionDataBase.executeQuery("select * from Taxe");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from taxe where id_taxe="+id);
}
public ResultSet rechercheByLibille(String s)
{
	return ConnectionDataBase.executeQuery("select * from taxe where libelle='"+s+"'");
}

public void supprimerTaxe(int id)
{String req="delete from taxe where id_taxe="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}
public Taxe getTaxe(int ligne)
{
return mytablemodel.getLigne(ligne);
}


}


