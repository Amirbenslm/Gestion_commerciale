package ControlerPack;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Bon_livraison_vente;



public class Bon_livraison_venteModel extends AbstractTableModel{
	int nblig;
	private int id_bon_livraison;
	private String ref_bon_livraison ;
	private int id_doc_vente;
	private int id_facture;

	Bon_livraison_vente c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Bon_livraison_vente> data=new ArrayList<Bon_livraison_vente>();
	public  Bon_livraison_venteModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_bon_livraison=rs.getInt(1);
				ref_bon_livraison=rs.getString(2);
				id_doc_vente=rs.getInt(3);
				id_facture=rs.getInt(4);
				c=new  Bon_livraison_vente(id_bon_livraison,ref_bon_livraison,id_doc_vente,id_facture);
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
		
		Bon_livraison_vente cl=data.get(l);
		if(c==0)
			{return cl.getId_bon_livraison();
		  }
			if(c==1)
			{return cl.getRef_bon_livraison();	}
			
		   if(c==2)
			{return cl.getId_doc_vente();}
		if(c==3)
			{return cl.getId_facture();
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
	public void AjouterLigne(Bon_livraison_vente f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Bon_livraison_vente f)
	{int a=RechercheBYID(f.getId_bon_livraison());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_bon_livraison()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}