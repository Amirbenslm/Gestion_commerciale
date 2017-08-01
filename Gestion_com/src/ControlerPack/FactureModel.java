package ControlerPack;

import java.awt.GraphicsConfiguration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import classPack.Facture;



public class FactureModel extends AbstractTableModel{
	int nblig;
	int id_facture,id_doc_vente;
	String ref_Facture;
	float retour_source,fodec,taxe_fiscale;
	Facture c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Facture> data=new ArrayList<Facture>();
	public  FactureModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_facture=rs.getInt(1);
				ref_Facture=rs.getString(2);
				retour_source=rs.getFloat(3);
				taxe_fiscale=rs.getFloat(4);
				fodec=rs.getFloat(5);
				id_doc_vente=rs.getInt(6);
				c=new Facture(id_facture,ref_Facture,retour_source,taxe_fiscale,fodec,id_doc_vente);
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
		String ch="";
		
		
		Facture cl=data.get(l);
		if(c==0)
			{return cl.getId_facture();
		  }
			if(c==1)
			{return cl.getReference();	}
		
		   if(c==2)
			{return cl.getRetour_source();}
		if(c==3)
			{return cl.getTaxe_fiscale();
		}
		if(c==4)
			{return cl.getFodec();}
		if(c==5)
		{
			return cl.getId_doc_vente();
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
	public void AjouterLigne(Facture f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Facture f)
	{int a=RechercheBYID(f.getId_facture());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_facture()==id)
	{System.out.println(data.get(i).getId_facture());
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	public Facture getFacture(int id) {
		int ligne=RechercheBYID(id);
		return data.get(ligne);
		
	}
	

	
}