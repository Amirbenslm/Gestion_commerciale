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
	ConnectionDataBase c=new ConnectionDataBase();
	Statement st;
	Connection con;
	public FamilleBase()
	{
		c.loadDriver("com.mysql.jdbc.Driver");
		c.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");	
	}
	public Famille AjoutFamille(Famille a1)
	{String req="INSERT INTO famille(nom_famille,id_taxe) VALUES('"+a1.getNom_famille()+"',"+a1.getId_taxe()+")";
	String exsist="select * from famille where nom_famille='"+a1.getNom_famille()+"'"+"and id_taxe="+a1.getId_taxe();
	ResultSet existe=c.executeQuery(exsist);
	try {
		if (existe.next())
			{JOptionPane.showMessageDialog(null," existe deja une Famille de même données !","Erreur",JOptionPane.ERROR_MESSAGE);
			return null;
			}
		else c.executeUpdate(req);
	} catch (HeadlessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String rech="select max(id_famille)from famille where nom_famille='"+a1.getNom_famille()+"'"+"and id_taxe="+a1.getId_taxe();
		try {
		ResultSet rs=c.executeQuery(rech);
		rs.next();
		a1.setId_fammille(rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a1;
	}
	public ResultSet affiche()
	{ResultSet rs = null;
		rs=c.executeQuery("select * from famille");
		return rs ;
	}
	public int ModifierFamille(Famille a1) {
		String req="update famille set nom_famille='"+a1.getNom_famille()+"'"+", id_taxe="+a1.getId_taxe();
	int x=c.executeUpdate(req);
	return x;
	}
	public void supprimerFamille(int id)
	{String req="delete from famille where id_famille="+id;
		int a=c.executeUpdate(req);
		if(a<1)
			JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
}
	public ResultSet rechercheByID(int id)
	{
		return c.executeQuery("select * from famille where id_famille="+id);
	}
	public ResultSet rechercheByNomFamille(String s)
	{
		return c.executeQuery("select * from famille where nom_famille='"+s+"'");
	}
	public ResultSet rechercheByIDTaxe(int id)
	{
		return c.executeQuery("select * from famille where id_taxe="+id);
	}
}
