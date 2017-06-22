package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import classPack.Caissier;


public class CaissierModel extends AbstractTableModel{
	int nblig;
	int id_caissier;
	String ncin,nom,adresse,ville,prenom,login,pwd,telephone;
	Caissier c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Caissier> data=new ArrayList<Caissier>();
	public CaissierModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_caissier=rs.getInt(1);
				ncin=rs.getString(2);
				nom=rs.getString(3);
				prenom=rs.getString(4);
				adresse=rs.getString(5);
				ville=rs.getString(6);
				
				telephone=rs.getString(7);
				login=rs.getString(8);
				pwd=rs.getString(9);
				c=new Caissier(id_caissier,ncin,nom,prenom,adresse,telephone,ville,login,pwd);
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
		
		
		 Caissier cl=data.get(l);
		if(c==0)
			{return cl.getId_caissier();
		  }
			if(c==1)
			{return cl.getNcin();	}
		
		   if(c==2)
			{ch=cl.getNom();
		
		return ch;}
		if(c==3)
			{return cl.getPrenom();
		}
		if(c==4)
			{return cl.getAdresse();}
		if(c==5)
		{
			return cl.getVille();
		}
		if(c==6)
		{
			return cl.getTelephone();
		}
		if(c==7)
		{
			return cl.getLogin();
		}
		if(c==8)
		{
			return cl.getPwd();
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
	public void AjouterLigne(Caissier f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Caissier f)
	{int a=RechercheBYID(f.getId_caissier());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{System.out.println(i);
	if(data.get(i).getId_caissier()==id)
	{System.out.println(data.get(i).getId_caissier());
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

public void AfficheData()
{int i=0;
	while(i<data.size())
	{//System.out.println(data.get(i).getId()+" "+data.get(i).getReference()+"     "+data.get(i).getRason_social()+" "+data.get(i).getAdresse()+"  "+data.get(i).getVille()+"  "+data.get(i).getMatricule_fiscale()+" "+data.get(i).getNum_reg_commerciale()+"  "+data.get(i).getNum_tel() );
i++;
}
	}
}