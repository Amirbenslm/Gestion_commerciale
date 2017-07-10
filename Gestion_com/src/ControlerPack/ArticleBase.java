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
	public static ArticleModel mytablemodel;
	
	public ArticleBase()
	{ mytablemodel=new ArticleModel(affiche());
		}
	public Article AjoutArticle(Article a1)
	{String req="INSERT INTO article(reference,designation,prix_unitaire,prix_TTC,qte_stock,qte_min,code_abar,id_famille,id_taxe) VALUES('"+a1.getReference()+"','"+a1.getDesignation()+"',"+a1.getPrix_unitaire()+","+a1.getPrixTTc()+","+a1.getQuantiteStock()+","+a1.getQuantiteMin()+",'"+a1.getCodeAbarre()+"',"+a1.getId_famille()+","+a1.getId_taxe()+")";
	String exsist="select * from article where reference='"+a1.getReference()+"'"+"and designation='"+a1.getDesignation()+"'"+"and prix_unitaire="+a1.getPrix_unitaire()+"and prix_TTC="+a1.getPrixTTc()+"and qte_stock="+a1.getQuantiteStock()+"and qte_min="+a1.getQuantiteMin()+"and code_abar='"+a1.getCodeAbarre()+"'"+" and Id_famille="+a1.getId_famille()+" and Id_taxe="+a1.getId_taxe();
	String rech="select max(id_article)from article where reference='"+a1.getReference()+"'"+"and designation='"+a1.getDesignation()+"'"+"and prix_unitaire="+a1.getPrix_unitaire()+"and prix_TTC="+a1.getPrixTTc()+"and qte_stock="+a1.getQuantiteStock()+"and qte_min="+a1.getQuantiteMin()+"and code_abar='"+a1.getCodeAbarre()+"'"+" and Id_famille="+a1.getId_famille()+" and Id_taxe="+a1.getId_taxe();
	
	ResultSet existe=ConnectionDataBase.executeQuery(exsist);
	try {
		if (existe.next())
			{JOptionPane.showMessageDialog(null," existe un Article deja de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
			return null;
			}
		else {ConnectionDataBase.executeUpdate(req);
		ResultSet rs=ConnectionDataBase.executeQuery(rech);
		rs.next();
		a1.setId_article(rs.getInt(1));
		mytablemodel.AjouterLigne(a1);
		}
		
	} catch (HeadlessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		return a1;
	}
	public ResultSet affiche()
	{ResultSet rs = null;
		rs=ConnectionDataBase.executeQuery("select * from article");
		return rs ;
	}
	public int ModifierArticle(Article a1) {
		String req="update article set reference='"+a1.getReference()+"'"+", designation='"+a1.getDesignation()+"'"+", prix_unitaire="+a1.getPrix_unitaire()+", prix_TTC="+a1.getPrixTTc()+", qte_stock="+a1.getQuantiteStock()+", qte_min="+a1.getQuantiteMin()+", code_abar='"+a1.getCodeAbarre()+"'"+", Id_famille="+a1.getId_famille()+", Id_taxe="+a1.getId_taxe()+" where id_article="+a1.getId_article();
	int x=ConnectionDataBase.executeUpdate(req);
	mytablemodel.ModifierLigne(a1);
	return x;
	}
	public void supprimerArticle(int id)
	{String req="delete from article where id_article="+id;
		int a=ConnectionDataBase.executeUpdate(req);
		
		if(a<0)
			JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
		else{
	mytablemodel.supprimerLigne(id);
}
	}
public ResultSet rechercheByID(int id)
	{
		return ConnectionDataBase.executeQuery("select * from article where id_article="+id);
	}
	public ResultSet rechercheByReference(String s)
	{
		return ConnectionDataBase.executeQuery("select * from article where reference='"+s+"'");
	}
	public ResultSet rechercheByVille(String s)
	{
		return ConnectionDataBase.executeQuery("select * from article where designation='"+s+"'");
	}
	public Article getArticle(int selectedRow) {
		// TODO Auto-generated method stub
		return mytablemodel.getArticle(selectedRow);
	}
}