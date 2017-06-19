package ControlerPack;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import classPack.Article;
import classPack.Fournisseur;

public class ArticleBase {
	ConnectionDataBase c=new ConnectionDataBase();
	Statement st;
	Connection con;
	public ArticleBase()
	{
		c.loadDriver("com.mysql.jdbc.Driver");
		c.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
	}
	public Article AjoutArticle(Article a1)
	{String req="INSERT INTO article(reference,designation,prix_unitaire,prix_TTC,qte_stock,qte_min,code_abar,id_famille,id_taxe) VALUES('"+a1.getReference()+"','"+a1.getDesignation()+"',"+a1.getPrix_unitaire()+","+a1.getPrixTTc()+","+a1.getQuantiteStock()+","+a1.getQuantiteMin()+",'"+a1.getCodeAbarre()+"',"+a1.getId_famille()+","+a1.getId_taxe()+")";
	String exsist="select * from article where reference='"+a1.getReference()+"'"+"and designation='"+a1.getDesignation()+"'"+"and prix_unitaire="+a1.getPrix_unitaire()+"and prix_TTC="+a1.getPrixTTc()+"and qte_stock="+a1.getQuantiteStock()+"and qte_min="+a1.getQuantiteMin()+"and code_abar='"+a1.getCodeAbarre()+"'"+" and Id_famille="+a1.getId_famille()+" and Id_taxe="+a1.getId_taxe();
	ResultSet existe=c.executeQuery(exsist);
	try {
		if (existe.next())
			{JOptionPane.showMessageDialog(null," existe un Article deja de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
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
	String rech="select max(id_article)from article where reference='"+a1.getReference()+"'"+"and designation='"+a1.getDesignation()+"'"+"and prix_unitaire="+a1.getPrix_unitaire()+"and prix_TTC="+a1.getPrixTTc()+"and qte_stock="+a1.getQuantiteStock()+"and qte_min="+a1.getQuantiteMin()+"and code_abar='"+a1.getCodeAbarre()+"'"+" and Id_famille="+a1.getId_famille()+" and Id_taxe="+a1.getId_taxe();
		try {
		ResultSet rs=c.executeQuery(rech);
		rs.next();
		a1.setId_article(rs.getInt(1));
			System.out.println(rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a1;
	}
	public ResultSet affiche()
	{ResultSet rs = null;
		rs=c.executeQuery("select * from article");
		return rs ;
	}
	public int ModifierArticle(Article a1) {
		String req="update article set reference='"+a1.getReference()+"'"+", designation='"+a1.getDesignation()+"'"+", prix_unitaire="+a1.getPrix_unitaire()+", prix_TTC="+a1.getPrixTTc()+", qte_stock="+a1.getQuantiteStock()+", qte_min="+a1.getQuantiteMin()+", code_abar='"+a1.getCodeAbarre()+"'"+", Id_famille="+a1.getId_famille()+", Id_taxe="+a1.getId_taxe()+" where id_article="+a1.getId_article();
	int x=c.executeUpdate(req);
	return x;
	}
	public void supprimerArticle(int id)
	{String req="delete from article where id_article="+id;
		int a=c.executeUpdate(req);
		if(a<1)
			JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
}
	public ResultSet rechercheByID(int id)
	{
		return c.executeQuery("select * from article where id_article="+id);
	}
	public ResultSet rechercheByReference(String s)
	{
		return c.executeQuery("select * from article where reference='"+s+"'");
	}
	public ResultSet rechercheByVille(String s)
	{
		return c.executeQuery("select * from article where designation='"+s+"'");
	}
}