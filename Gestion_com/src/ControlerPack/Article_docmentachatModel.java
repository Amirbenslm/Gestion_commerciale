package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Article_docmentachat;



public class Article_docmentachatModel extends AbstractTableModel{
	int nblig;
	int id_article_docAchat,id_article,id_docAchat;

	Article_docmentachat c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Article_docmentachat> data=new ArrayList<Article_docmentachat>();
	public  Article_docmentachatModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_article_docAchat=rs.getInt(1);
				id_article=rs.getInt(2);
				id_docAchat=rs.getInt(3);
				c=new Article_docmentachat(id_article_docAchat,id_article,id_docAchat);
				data.add(c);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public int getRowCount() {
		return nblig;
	}
	@Override
	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public Object getValueAt(int l, int c) {
		
		Article_docmentachat cl=data.get(l);
		if(c==0)
			{return cl.getId_article_docAchat();
		  }
			if(c==1)
			{return cl.getId_article();	}
			
		   if(c==2)
			{return cl.getId_docAchat();}
		
		
		return("erreur");
		
	}
	@Override
	public String getColumnName(int l) {
	
		try {
			return rsmd.getColumnName(l+1);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public void supprimerLigne(int l){
		try{
		int a=RechercheBYID(l);
	data.remove(a);
	nblig --;
    fireTableDataChanged();
		}catch(Exception e){}		
	}
	public void AjouterLigne(Article_docmentachat f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Article_docmentachat f)
	{int a=RechercheBYID(f.getId_article_docAchat());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_article_docAchat()==id)
	{System.out.println(data.get(i).getId_article_docAchat());
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}