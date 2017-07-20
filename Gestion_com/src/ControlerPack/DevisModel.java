package ControlerPack;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Devis;





public class DevisModel extends AbstractTableModel{
	int nblig;
	private int id_devis;
	private String ref_devis ;
	private int id_doc_vente;
	private int id_bon_livraison;

	Devis c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Devis> data=new ArrayList<Devis>();
	public  DevisModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_devis=rs.getInt(1);
				ref_devis=rs.getString(2);
				id_doc_vente=rs.getInt(3);
				id_bon_livraison=rs.getInt(4);
				c=new  Devis(id_devis,ref_devis,id_doc_vente,id_bon_livraison);
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
		
		Devis cl=data.get(l);
		if(c==0)
			{return cl.getId_devis();
		  }
			if(c==1)
			{return cl.getReference();	}
			
		   if(c==2)
			{return cl.getId_doc_vente();}
		if(c==3)
			{return cl.getId_bon_livraison();
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
	public void AjouterLigne(Devis f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Devis f)
	{int a=RechercheBYID(f.getId_devis());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_devis()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}