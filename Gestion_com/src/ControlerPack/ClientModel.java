package ControlerPack;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

import classPack.Article;
import classPack.Client;

public class ClientModel extends AbstractTableModel {
	int nblig;
	int idclient;
	String nom,prenom,ncin,date,adr,ville,m_fiscale,reg_comm,tel,email;
	Client c;
	private ResultSetMetaData rsmd;
	ArrayList <Client> data=new ArrayList<Client>();
	public  ClientModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				idclient=rs.getInt(1);
				nom=rs.getString(3);
				prenom=rs.getString(4);
				ncin=rs.getString(2);
				date=rs.getString(5);
				adr=rs.getString(6);
				ville=rs.getString(7);
				m_fiscale=rs.getString(10);
				reg_comm=rs.getString(11);
				tel=rs.getString(8);
				email=rs.getString(9);
				c=new Client(idclient,nom, prenom, ncin, date, adr, ville, m_fiscale, reg_comm, tel, email);
				data.add(c);
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
			
			 Client cl=data.get(l);
			if(c==0)
				{a=cl.getIdClient();
			return a; }
				if(c==2)
				{ch=cl.getNom();
			return ch;}
			
			   if(c==3)
				{ch=cl.getPrenom();
			
			return ch;}
			if(c==1)
				{ch=cl.getCin();
			return ch;}
			if(c==4)
				{ch=cl.getDateclient();
			return ch;}
			if(c==5)
			{
				return cl.getAdresse();
			}
			if(c==6)
			{
				return cl.getVille();
			}
			if(c==9)
			{
				return cl.getMatricule_fiscale();
			}
			if(c==10)
			{
				return cl.getNum_reg_commerciale();
			}
			if(c==7)
			{
				return cl.getTel();
			}
			if(c==8)
			{
				return cl.getEmail();
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
		{
		
		data.remove(l);
	    nblig --;
	    fireTableDataChanged();
		}
		
		public void ajouterLigne(Client c) {
			
			
			System.out.print(c.getTel()+"   "+c.getEmail());
			data.add(c);
			nblig++;
			fireTableDataChanged();
		}
		public void ModifierLigne(Client c)
		{
			int l=rechercheId(c.getIdClient());
			data.set(l,c);
		fireTableDataChanged();

		}
		
		public int rechercheId(int id)
		{
			int i=0;Boolean b=false;
			while(i<data.size()&& !b)
			{ 
				if(data.get(i).getIdClient()==id)
				{
					b=true;
				}
				i++;
			}
			return i-1;
		}
		public Client getClient(int id) {
			int ligne=rechercheId(id);
			return data.get(ligne);
		}



}
