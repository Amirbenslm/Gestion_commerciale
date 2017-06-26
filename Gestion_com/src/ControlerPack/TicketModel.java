package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classPack.Ticket;

public class TicketModel extends AbstractTableModel{
	int nblig;
	int id_ticket,id_doc_vente,id_caissier;
	String reference,date;
	Ticket c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Ticket> data=new ArrayList<Ticket>();
	public  TicketModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_ticket=rs.getInt(1);
				reference=rs.getString(2);
				date=rs.getString(3);
				id_doc_vente=rs.getInt(4);
				id_caissier=rs.getInt(5);
				c=new Ticket(id_ticket,reference,date,id_doc_vente,id_caissier);
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
		
		Ticket cl=data.get(l);
		if(c==0)
			{return cl.getId_ticket();
		  }
			if(c==1)
			{return cl.getReference();	}
			if(c==2)
			{return cl.getDate();	}
		
		   if(c==3)
			{return cl.getId_doc_vente();}
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
	public void AjouterLigne(Ticket f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Ticket f)
	{int a=RechercheBYID(f.getId_ticket());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_ticket()==id)
	{System.out.println(data.get(i).getId_ticket());
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}