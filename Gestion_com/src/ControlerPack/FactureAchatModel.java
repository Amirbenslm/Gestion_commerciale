package ControlerPack;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Client;
import classPack.Facture_Achat;

public class FactureAchatModel extends AbstractTableModel{
	int nblig;
	int id_factureAchat,id_docAchat;
	float retour_source,t_fiscale,fodec;
	String ref_factureAchat;
	Client c;
	private ResultSetMetaData rsmd;
	ArrayList <Facture_Achat> data=new ArrayList<Facture_Achat>();
	public  FactureAchatModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_factureAchat=rs.getInt(1);
				ref_factureAchat=rs.getString(2);
				retour_source=rs.getFloat(3);
				t_fiscale=rs.getFloat(4);
				fodec=rs.getFloat(5);
				id_docAchat=rs.getInt(6);
                Facture_Achat f=new Facture_Achat(id_factureAchat, ref_factureAchat, retour_source, t_fiscale, fodec,id_docAchat);
				data.add(f);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
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
		public int getRowCount() {
			return nblig;
		}

		@Override
		public Object getValueAt(int l, int c) {
			String ch="";
			int a=0;
			float b=0;
			 Facture_Achat f=data.get(l);
			if(c==0)
				{a=f.getId_factureAchat();
			return a; }
				if(c==1)
				{ch=f.getReference();
			return ch;}
			
			   if(c==2)
				{b=f.getRetour_source();
			
			return b;}
			if(c==3)
				{b=f.getTaxe_fiscale();
			return b;}
			if(c==4)
				{b=f.getFodec();
			return b;}
			if(c==5)
			{
				a=f.getId_docAchat();
				return a;
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
		
		
		/*public boolean isCellEditable(int l, int c) {
			
			if(c==4)
				return true;
			else
				return false;
		}*/
		public void supprimerLigne (int l)
		{int ligne=rechercheId(l);
		data.remove(ligne);
	    nblig --;
	    fireTableDataChanged();
		}
   public void ajouterLigne(Facture_Achat f) {
			
			data.add(f);
			nblig++;
			fireTableDataChanged();
		}
   
   public void ModifierLigne(Facture_Achat f)
	{
		int l=rechercheId(f.getId_factureAchat());
		data.set(l,f);
	fireTableDataChanged();

	}
	public int rechercheId(int id)
	{
		int i=0;Boolean b=false;
		while(i<data.size()&& !b)
		{ 
			if(data.get(i).getId_factureAchat()==id)
			{
				b=true;
			}
			i++;
		}
		return i-1;
	}
	

}
