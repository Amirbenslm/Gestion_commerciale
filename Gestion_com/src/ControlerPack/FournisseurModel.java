package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import classPack.Fournisseur;

public class FournisseurModel extends AbstractTableModel{
	int nblig;
	int idFournisseur;
	String ref_fournisseur,raison_social,adresse,ville,matricule_fiscale,num_reg_commercial,num_tel;
	Fournisseur c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Fournisseur> data=new ArrayList<Fournisseur>();
	public  FournisseurModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				idFournisseur=rs.getInt(1);
				ref_fournisseur=rs.getString(2);
				raison_social=rs.getString(3);
				adresse=rs.getString(4);
				ville=rs.getString(5);
				matricule_fiscale=rs.getString(6);
				num_reg_commercial=rs.getString(7);
				num_tel=rs.getString(8);
		//	System.out.println(idFournisseur+ref_fournisseur+raison_social+adresse+ville+matricule_fiscale+num_reg_commercial+num_tel);
				c=new Fournisseur(idFournisseur,ref_fournisseur,raison_social,adresse,ville,matricule_fiscale,num_reg_commercial,num_tel);
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
		
		
		 Fournisseur cl=data.get(l);
		if(c==0)
			{return cl.getId();
		  }
			if(c==1)
			{return cl.getReference();	}
		
		   if(c==2)
			{ch=cl.getRason_social();
		
		return ch;}
		if(c==3)
			{return cl.getAdresse();
		}
		if(c==4)
			{return cl.getVille();}
		if(c==5)
		{
			return cl.getMatricule_fiscale();
		}
		if(c==6)
		{
			return cl.getNum_reg_commerciale();
		}
		if(c==7)
		{
			return cl.getNum_tel();
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
	public void AjouterLigne(Fournisseur f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Fournisseur f)
	{int a=RechercheBYID(f.getId());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{System.out.println(i);
	if(data.get(i).getId()==id)
	{System.out.println(data.get(i).getId());
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

public void AfficheData()
{int i=0;
	while(i<data.size())
	{System.out.println(data.get(i).getId()+" "+data.get(i).getReference()+"     "+data.get(i).getRason_social()+" "+data.get(i).getAdresse()+"  "+data.get(i).getVille()+"  "+data.get(i).getMatricule_fiscale()+" "+data.get(i).getNum_reg_commerciale()+"  "+data.get(i).getNum_tel() );
i++;
}
	}
}