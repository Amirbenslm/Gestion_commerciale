package ControlerPack;



import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import classPack.Article_docmentachat;






public class Article_docmentachatBase{

	public Article_docmentachatModel mytablemodel;
	
	public Article_docmentachatBase()
	{
		
		mytablemodel=new Article_docmentachatModel(ConnectionDataBase.executeQuery("select * from Article_docmentachat"));


	}
public boolean AjoutArticle_docmentachat(Article_docmentachat f1)
{String req="INSERT INTO Article_docmentachat(id_article,id_docAchat) VALUES("+f1.getId_article()+","+f1.getId_docAchat()+")";
String rech="select max(id_article_docAchat) from Article_docmentachat where id_article="+f1.getId_article()+" and id_docAchat="+f1.getId_docAchat();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_article_docAchat(rs.getInt(1));
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


public int ModifierArticle_docmentachat(Article_docmentachat f1)
{String req="update  Article_docmentachat set id_article="+f1.getId_article()+",id_docAchat="+f1.getId_docAchat()+" where id_article_docAchat="+f1.getId_article_docAchat();	
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
	rs=ConnectionDataBase.executeQuery("select * from Article_docmentachat");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from Article_docmentachat where id_article_docAchat="+id);
}

public void supprimerArticle_docmentachat(int id)
{String req="delete from Article_docmentachat where id_article_docAchat="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


