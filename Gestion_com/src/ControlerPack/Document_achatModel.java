package ControlerPack;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import classPack.Document_achat;




public class Document_achatModel extends AbstractTableModel{
		private int id_documentA ;
		private String date_doccumentA;
		private int id_fournisseur;
		//private int id_article;
int nblig;
Document_achat c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Document_achat> data=new ArrayList<Document_achat>();
	public  Document_achatModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_documentA=rs.getInt(1);
				date_doccumentA=rs.getString(2);
				id_fournisseur=rs.getInt(3);
				//id_article=rs.getInt(4);
				c=new  Document_achat(id_documentA,date_doccumentA,0,id_fournisseur);
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
		
		Document_achat cl=data.get(l);
		if(c==0)
			{return cl.getId_documentA();
		  }
			if(c==1)
			{return cl.getDateDoccument();	}
			
		   if(c==2)
			{return cl.getId_fournisseur();}
	/*	if(c==3)
			{return cl.getId_article();
		}*/
		
		
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
	public void AjouterLigne(Document_achat f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Document_achat f)
	{int a=RechercheBYID(f.getId_documentA());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_documentA()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}