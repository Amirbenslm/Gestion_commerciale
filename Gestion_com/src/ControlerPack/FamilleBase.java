package ControlerPack;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import classPack.Article;
import classPack.Famille;

public class FamilleBase {
FamilleModel mytablemodel;
	public FamilleBase()
	{
		mytablemodel=new FamilleModel(affiche());
	}
	public void AjoutFamille(Famille a1)
	{String req="INSERT INTO famille(nom_famille,id_taxe) VALUES('"+a1.getNom_famille()+"',"+a1.getId_taxe()+")";
	String exsist="select * from famille where nom_famille='"+a1.getNom_famille()+"'"+"and id_taxe="+a1.getId_taxe();
	String rech="select max(id_famille)from famille where nom_famille='"+a1.getNom_famille()+"'"+"and id_taxe="+a1.getId_taxe();

	ResultSet existe=ConnectionDataBase.executeQuery(exsist);
	try {
		if (existe.next())
			{JOptionPane.showMessageDialog(null," existe deja une Famille de même données !","Erreur",JOptionPane.ERROR_MESSAGE);
			 
			}
		else {
		ConnectionDataBase.executeUpdate(req);
		ResultSet rs=ConnectionDataBase.executeQuery(rech);
		rs.next();
		a1.setId_fammille(rs.getInt(1));
		
		mytablemodel.AjouterLigne(a1);
		}
	} catch (HeadlessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		
	}
	public ResultSet affiche()
	{ResultSet rs = null;
		rs=ConnectionDataBase.executeQuery("select * from famille");
		return rs ;
	}
	public int ModifierFamille(Famille a1) {
		String req="update famille set nom_famille='"+a1.getNom_famille()+"'"+", id_taxe="+a1.getId_taxe()+" where id_famille="+a1.getId_fammille();
	int x=ConnectionDataBase.executeUpdate(req);
	if(x>0) 
	{mytablemodel.ModifierLigne(a1);}
	return x;
	}
	public void supprimerFamille(int id)
	{String req="delete from famille where id_famille="+id;
		int a=ConnectionDataBase.executeUpdate(req);
		if(a<1)
			JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
		else
		{mytablemodel.supprimerLigne(id);}
	}
	public ResultSet rechercheByID(int id)
	{
		return ConnectionDataBase.executeQuery("select * from famille where id_famille="+id);
	}
	public ResultSet rechercheByNomFamille(String s)
	{
		return ConnectionDataBase.executeQuery("select * from famille where nom_famille='"+s+"'");
	}
	public ResultSet rechercheByIDTaxe(int id)
	{
		return ConnectionDataBase.executeQuery("select * from famille where id_taxe="+id);
	}
}
