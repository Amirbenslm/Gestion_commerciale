package ControlerPack;



import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Cloture;






public class ClotureBase{

	public ClotureModel mytablemodel;
	
	public ClotureBase()
	{
		
		mytablemodel=new ClotureModel(ConnectionDataBase.executeQuery("select * from cloture"));


	}
public boolean AjoutCloture(Cloture f1)
{String req="INSERT INTO Cloture(date,montant_ouverture,montant_fermeture,id_caissier) VALUES('"+f1.getDate()+"','"+f1.getMontant_ouverture()+"',"+f1.getMontant_fermeture()+","+f1.getId_cassier()+")";
String rech="select max(id_cloture) from cloture where date='"+f1.getDate()+"'"+"and montant_ouverture="+f1.getMontant_ouverture()+" and montant_fermeture="+f1.getMontant_fermeture()+" and id_caissier="+f1.getId_cassier();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_cloture(rs.getInt(1));
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


public int ModifierCloture(Cloture f1)
{String req="update  cloture set date='"+f1.getDate()+"',montant_ouverture="+f1.getMontant_ouverture()+",montant_fermeture="+f1.getMontant_fermeture()+",id_caissier="+f1.getId_cassier()+" where id_cloture="+f1.getId_cloture();	
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
	rs=ConnectionDataBase.executeQuery("select * from cloture");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from cloture where id_cloture="+id);
}
public ResultSet rechercheByIDCaissier(int id)
{
	return ConnectionDataBase.executeQuery("select * from cloture where id_caissier="+id);
}
public ResultSet rechercheByDate(String s)
{
	return ConnectionDataBase.executeQuery("select * from cloture where date like '"+s+"'");
}
public void supprimerCloture(int id)
{String req="delete from cloture where id_cloture="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


