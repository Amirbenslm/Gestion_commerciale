package ControlerPack;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classPack.Facture_Achat;

public class FactureAchatBase {
	FactureAchatModel fam=null;
	public  FactureAchatBase(ResultSet rs) {
		// TODO Auto-generated constructor stub
		fam=new FactureAchatModel(rs);
	}
	public void supprimerFactureAchat(int l)
	{
	String req="DELETE FROM `facture_achat` WHERE `id_factureA`="+l;
	int a =ConnectionDataBase.executeUpdate(req);
	if(a<1)
	{
		JOptionPane.showMessageDialog(null,"suppression echoué!","Erreur",JOptionPane.ERROR_MESSAGE);

	}
	fam.supprimerLigne(l);
	}
	public void ajouterFactureAchat(Facture_Achat f) {
		String req="INSERT INTO `facture_achat`( `ref_factureA`, `retour_source`, `t_fiscale`, `fodec`, `id_doc_achat`) VALUES('"+f.getReference()+"',"+f.getRetour_source()+","+f.getTaxe_fiscale()+","+f.getFodec()+","+f.getId_docAchat()+")";
		//ConnectionDataBase.executeUpdate(req);
		String rech="SELECT max(id_factureA)FROM `facture_achat` WHERE `ref_factureA`='"+f.getReference()+"'"+"and `retour_source`="+f.getRetour_source()+"and `t_fiscale`="+f.getTaxe_fiscale()+"and `fodec`="+f.getFodec()+"and `id_doc_achat`="+f.getId_docAchat();
				try {
		/*ResultSet rs=ConnectionDataBase.executeQuery(rech);
		
		if(rs.next())
		
			{JOptionPane.showMessageDialog(null," existe deja un client de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
			
			}
		else {*/ConnectionDataBase.executeUpdate(req);
		ResultSet rs1=ConnectionDataBase.executeQuery(rech);
		rs1.next();
		f.setId_factureAchat(rs1.getInt(1));
        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		fam.ajouterLigne(f);
	}
	public ResultSet affiche()
	{ResultSet rs=null;
		rs=ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat`");
		return rs;
		
		
	}
	
	public ResultSet rechercheByID(int id)
	{
		return ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat` WHERE `id_factureA`="+id);
	}
	public ResultSet rechercheByReference(String nc)
	{
		return ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat` WHERE `ref_factureA`='"+nc+"'");
	}
	public ResultSet rechercheByRS(float s)
	{
		return ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat` WHERE `retour_source`="+s);
	}
	public ResultSet rechercheByTFiscale(float s)
	{
		return ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat` WHERE  `t_fiscale`="+s);
	}
	
	public ResultSet rechercheByFodec(float s)
	{
		return ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat` WHERE  `fodec`="+s);
	}
	
	public ResultSet rechercheByIdDocAchat(int s)
	{
		return ConnectionDataBase.executeQuery("SELECT * FROM `facture_achat` WHERE  `id_doc_achat`="+s);
	}
	
	public void modifierFactureAchat(Facture_Achat f)
	{
		String modifreq="UPDATE `facture_achat` SET `ref_factureA`='"+f.getReference()+"',`retour_source`="+f.getRetour_source()+",`t_fiscale`="+f.getTaxe_fiscale()+",`fodec`="+f.getFodec()+",`id_doc_achat`="+f.getId_docAchat()+" WHERE `id_factureA`="+f.getId_factureAchat();
       ConnectionDataBase.executeUpdate(modifreq);
     
       
       fam.ModifierLigne(f);
        
      
	}
	
	

		
		  
	

}
