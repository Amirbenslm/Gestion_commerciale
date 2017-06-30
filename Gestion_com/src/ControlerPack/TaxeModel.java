package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Taxe;


public class TaxeModel extends AbstractTableModel{
	int nblig;
	int id_taxe;
	String libelle;
	float taux;
	Taxe c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Taxe> data=new ArrayList<Taxe>();
	public  TaxeModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_taxe=rs.getInt(1);
				libelle=rs.getString(2);
				taux=rs.getFloat(3);
				c=new Taxe(id_taxe,libelle,taux);
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
		
		Taxe cl=data.get(l);
		if(c==0)
			{return cl.getId_taxe();
		  }
			if(c==1)
			{return cl.getLibelle();	}
			if(c==2)
			{return cl.getTaux();	}
		
		
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
	public void AjouterLigne(Taxe f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Taxe f)
	{int a=RechercheBYID(f.getId_taxe());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_taxe()==id)
	{System.out.println(data.get(i).getId_taxe());
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}