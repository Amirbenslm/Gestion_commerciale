package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import classPack.Ligne_vente;



public class Ligne_venteModel extends AbstractTableModel{
	int nblig;
	 int id_ligneVente ;
	 float quantite;
	 float remise;
	 float prix  ;
	 int id_doc_vente;
	 int id_article ;
	 Ligne_vente c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Ligne_vente> data=new ArrayList<Ligne_vente>();
	public Ligne_venteModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_ligneVente=rs.getInt(1);
				quantite=rs.getFloat(2);
				remise=rs.getFloat(3);
				prix=rs.getFloat(4);
				id_doc_vente=rs.getInt(5);
				id_article=rs.getInt(6);
				
				c=new Ligne_vente(id_ligneVente, quantite, remise, prix, id_doc_vente, id_article);
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
		
		Ligne_vente cl=data.get(l);
		if(c==0)
			{return cl.getId_ligneVente();
		  }
			if(c==1)
			{return cl.getQuantite();}
			
		   if(c==2)
			{return cl.getRemise();}
		   if(c==3)
			{return cl.getPrix();
		  }
			if(c==4)
			{return cl.getId_article();	}
			
		   if(c==5)
			{return cl.getId_doc_vente();}
		
		
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
	public void AjouterLigne(Ligne_vente f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Ligne_vente f)
	{int a=RechercheBYID(f.getId_ligneVente());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_ligneVente()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}