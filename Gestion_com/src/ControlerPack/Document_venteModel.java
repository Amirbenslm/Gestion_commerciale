package ControlerPack;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import classPack.Document_vente;



public class Document_venteModel extends AbstractTableModel{
		private int id_documentV ;
		private String date_doccumentV;
		private String type_doc;
		private int id_client;
		
int nblig;
Document_vente c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Document_vente> data=new ArrayList<Document_vente>();
	public  Document_venteModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_documentV=rs.getInt(1);
				date_doccumentV=rs.getString(2);
				type_doc=rs.getString(3);
				id_client=rs.getInt(4);
				
				c=new  Document_vente(id_documentV,date_doccumentV,type_doc,id_client);
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
		
		Document_vente cl=data.get(l);
		if(c==0)
			{return cl.getId_documentV();
		  }
			if(c==1)
			{return cl.getDate_doccumentV();	}
			if(c==2)
			{return cl.getType_doc();	}
			
		   if(c==3)
			{return cl.getId_client();}
		
		
		
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
	public void AjouterLigne(Document_vente f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Document_vente f)
	{int a=RechercheBYID(f.getId_documentV());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_documentV()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	public Document_vente getDoc(int id) {
		int ligne=RechercheBYID(id);
		return data.get(ligne);
		
	}
	

	
}