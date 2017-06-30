package ControlerPack;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import classPack.Reglement_vente;


public class Reglement_venteModel extends AbstractTableModel{
	private  int id_reg_vente ;
	private double montant;
	private String mode_paiement ;
	private String echeance ;
	private int id_doc_vente;
int nblig;
Reglement_vente c;
	private java.sql.ResultSetMetaData rsmd;
	ArrayList <Reglement_vente> data=new ArrayList<Reglement_vente>();
	public  Reglement_venteModel(ResultSet rs) {
		try
		{
			rsmd=rs.getMetaData();
			while(rs.next())
			{
				nblig++;
				id_reg_vente=rs.getInt(1);
				montant=rs.getDouble(2);
				mode_paiement=rs.getString(3);
				echeance=rs.getString(4);
				id_doc_vente=rs.getInt(5);
				c=new  Reglement_vente(id_reg_vente,montant,mode_paiement,echeance,id_doc_vente);
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
		
		Reglement_vente cl=data.get(l);
		if(c==0)
			{return cl.getId_reg_vente();
		  }
			if(c==1)
			{return cl.getMontant();	}
			
		   if(c==2)
			{return cl.getMode_payement();}
		if(c==3)
			{return cl.getEcheance();
		}
		if(c==4)
		{return cl.getId_doc_vente();
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
	public void AjouterLigne(Reglement_vente f){
		data.add(f);
		nblig ++;
	    fireTableDataChanged();
			
		}
	public void ModifierLigne(Reglement_vente f)
	{int a=RechercheBYID(f.getId_reg_vente());
		data.set(a,f);
	fireTableDataChanged();
		
	}
	public int RechercheBYID(int id)
	{int i=0;
	Boolean b=false;
	while(i<data.size()&&(b==false))
	{
	if(data.get(i).getId_doc_vente()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	

	
}