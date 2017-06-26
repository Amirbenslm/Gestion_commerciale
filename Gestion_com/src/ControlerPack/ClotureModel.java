package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Cloture;


public class ClotureModel extends AbstractTableModel{
	int nblig;
	int id_cloture,id_caissier;
	private  String date ;
	private double montant_ouverture;
	private double montant_fermeture;
	
	Cloture c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Cloture> data=new ArrayList<Cloture>();
	public  ClotureModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_cloture=rs.getInt(1);
				date=rs.getString(2);
				montant_ouverture=rs.getDouble(3);
				montant_fermeture=rs.getDouble(4);
				id_caissier=rs.getInt(5);
				c=new Cloture(id_cloture,date,montant_ouverture,montant_fermeture,id_caissier);
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
		
		Cloture cl=data.get(l);
		if(c==0)
			{return cl.getId_cloture();
		  }
			if(c==1)
			{return cl.getDate();	}
			if(c==2)
			{return cl.getMontant_ouverture();	}
		
		   if(c==3)
			{return cl.getMontant_fermeture();}
		if(c==4)
			{return cl.getId_cassier();
		}
		
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
	public void AjouterLigne(Cloture f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Cloture f)
	{int a=RechercheBYID(f.getId_cloture());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_cloture()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}