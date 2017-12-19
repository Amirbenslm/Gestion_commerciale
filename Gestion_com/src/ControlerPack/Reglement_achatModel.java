package ControlerPack;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Reglement_achat;





public class Reglement_achatModel extends AbstractTableModel{
	private  int id_reg_achat ;
	private double montant;
	private String mode_payement ;
	private String echeance ;
	private int id_doc_achat;
int nblig;
	Reglement_achat c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Reglement_achat> data=new ArrayList<Reglement_achat>();
	private String date_reglement;
	public  Reglement_achatModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_reg_achat=rs.getInt(1);
				montant=rs.getDouble(2);
				date_reglement=rs.getString(3);
				mode_payement=rs.getString(4);
				echeance=rs.getString(5);
				id_doc_achat=rs.getInt(6);
				c=new  Reglement_achat(id_reg_achat,montant,date_reglement,mode_payement,echeance,id_doc_achat);
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
		
		Reglement_achat cl=data.get(l);
		if(c==0)
			{return cl.getId_reg_achat();
		  }
			if(c==1)
			{return cl.getMontant();	}
			if(c==2)
			{return cl.getDate_reglement();	}
		   if(c==3)
			{return cl.getMode_payement();}
		if(c==4)
			{return cl.getEcheance();
		}
		if(c==5)
		{return cl.getId_doc_achat();
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
	public void AjouterLigne(Reglement_achat f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Reglement_achat f)
	{int a=RechercheBYID(f.getId_reg_achat());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_doc_achat()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}