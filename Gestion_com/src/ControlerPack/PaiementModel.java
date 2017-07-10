package ControlerPack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import classPack.ArticleVendue;
import classPack.Facture;



public class PaiementModel extends AbstractTableModel{
	int nblig;
	private	int id_article ;
	private	String designation;
	private	double prix ;
	private	double quantite;
	private	double remise ;
	private	double taxe ;
	ArticleVendue c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <ArticleVendue> data=new ArrayList<ArticleVendue>();
	private String ligne;
	private StringTokenizer st;
	public  PaiementModel(ResultSet rs) {
		
			try{
				InputStream ips=new FileInputStream("test.txt"); 
				
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
			//rsmd=rs.getMetaData();
			while((ligne=br.readLine())!=null)
			{
				nblig++;
				 st = new StringTokenizer(ligne,"***");
				id_article=Integer.parseInt(st.nextToken());
				designation=st.nextToken();
				prix=Double.parseDouble(st.nextToken());
				quantite=Double.parseDouble(st.nextToken());
				remise=Double.parseDouble(st.nextToken());
				taxe=Double.parseDouble(st.nextToken());
				c=new ArticleVendue(id_article, designation, prix, quantite, remise, taxe);
				data.add(c);
			}
			br.close(); 
		}
		catch(NumberFormatException | IOException e)
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
		return 6;
	}
	@Override
	public Object getValueAt(int l, int c) {
	
		
		
		ArticleVendue cl=data.get(l);
		if(c==0)
			{return cl.getId_article();
		  }
			if(c==1)
			{return cl.getDesignation();	}
		
		   if(c==2)
			{return cl.getPrix();}
		if(c==3)
			{return cl.getQuantite();
		}
		if(c==4)
			{return cl.getRemise();}
		if(c==5)
		{
			return cl.getTaxe();
		}
		return("erreur");
		
	}
	@Override
	public String getColumnName(int l) {
	
		if(l==0)
		return "id_article" ;
		if(l==1)
			return "Designation" ;
		if(l==2)
			return "Prix" ;
		if(l==3)
			return "Quantité" ;
		if(l==4)
			return "Remise %" ;
		if(l==5)
			return "Taxe %" ;
	
		return "erreeure";
	}
	
	public void supprimerLigne(int l){
		try{
		int a=RechercheBYID(l);
	data.remove(a);
	nblig --;
    fireTableDataChanged();
		}catch(Exception e){}		
	}
	public void AjouterLigne(ArticleVendue f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(ArticleVendue f)
	{int a=RechercheBYID(f.getId_article());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_article()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}