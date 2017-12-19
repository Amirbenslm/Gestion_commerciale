package ControlerPack;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import classPack.Reglement_vente;


public class Reglement_venteModel extends AbstractTableModel{
	private  int id_reg_vente ;
	private double montant;
	private String date_reglement;
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
				id_reg_vente=rs.getInt("id_reg_vente");
				montant=rs.getDouble("montant");
				date_reglement=rs.getString("date_reglement");
				mode_paiement=rs.getString("mode_paiement");
				echeance=rs.getString("echeance");
				id_doc_vente=rs.getInt("id_doc_vente");
				c=new  Reglement_vente(id_reg_vente,montant,date_reglement,mode_paiement,echeance,id_doc_vente);
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
			{return cl.getDate_reglement();	}
			
		   if(c==3)
			{return cl.getMode_payement();}
		if(c==4)
			{return cl.getEcheance();
		}
		if(c==5)
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
	if(data.get(i).getId_reg_vente()==id)
	{
	b=true;
	}	
	i++;
	}
			return i-1;
	}
	public Reglement_vente getReglement(int id) {
		int ligne=RechercheBYID(id);
		return data.get(ligne);
	}
	

	
}