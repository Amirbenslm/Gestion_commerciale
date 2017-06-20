package ControlerPack;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Article;
public class ArticleModel extends AbstractTableModel{
	int nblig;
	int id_article,id_famille,id_taxe;
	float prix_unitaire,prix_TTC,qte_stock,qte_min;
	String reference,designation,code_abar;
	Article c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Article> data=new ArrayList<Article>();

	public  ArticleModel (ResultSet rs){
		
		
			try
			{
				rsmd=rs.getMetaData();
				while(rs.next())
				{
					nblig++;
					id_article=rs.getInt(1);
					reference=rs.getString(2);
					designation=rs.getString(3);
					prix_unitaire=rs.getFloat(4);
					prix_TTC=rs.getFloat(5);
					qte_stock=rs.getInt(6);
					qte_min=rs.getInt(7);
					code_abar=rs.getString(8);
					id_famille=rs.getInt(9);
					id_taxe=rs.getInt(10);
				
				
					c=new Article(id_article,reference,designation,prix_unitaire,prix_TTC,qte_stock,qte_min,code_abar,id_famille,id_taxe);
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
						
			 Article cl=data.get(l);
			if(c==0)
				{return cl.getId_article();
			  }
				if(c==1)
				{return cl.getReference();	}
			
			   if(c==2)
				{return cl.getDesignation();}
			if(c==3)
				{return cl.getPrix_unitaire();
			}
			if(c==4)
				{return cl.getPrixTTc();}
			if(c==5)
			{
				return cl.getQuantiteStock();
			}
			if(c==6)
			{
				return cl.getQuantiteMin();
			}
			if(c==7)
			{
				return cl.getCodeAbarre();
			}
			if(c==8)
			{
				return cl.getId_famille();
			}
			if(c==9)
			{
				return cl.getId_taxe();
			}
			
			return("erreur");
			
		}
		public String getColumnName(int l) {
			
			try {
				return rsmd.getColumnName(l+1);
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
		}
		public void supprimerLigne(int l){
			int ligne=RechercheBYID(l);
		data.remove(ligne);
		nblig --;
	    fireTableDataChanged();
			
		}
		public void AjouterLigne(Article f){
			data.add(f);
			nblig ++;
		    fireTableDataChanged();
				
			}
		public void ModifierLigne(Article f)
		{int ligne=RechercheBYID(f.getId_article());
			data.set(ligne,f);
		fireTableDataChanged();
			
		}
		public int RechercheBYID(int id)
		{int i=0;
		Boolean b=false;
		while(i<data.size()&&(b==false))
		{
		if(data.get(i).getId_article()==id)
		{System.out.println(data.get(i).getId_article());
		b=true;
		}	
		i++;
		}
				return i-1;
		}
		}





