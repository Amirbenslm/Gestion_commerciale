package ControlerPack;


import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import classPack.Client;



public class ClientBase {
	
	ClientModel cm=null;
	public ClientBase( ResultSet rs)
	{
		
		cm=new ClientModel(rs);
		  
	}
	 
	/*public void intitClient() {
		String req="SELECT * FROM `client`";
				ResultSet rs=ConnectionDataBase.executeQuery(req);
				cm=new ClientModel(rs);
				//jtclient.setModel(mytablemodel);
	}*/
	
	public void supprimerClient(int l)
	{
	String req="DELETE FROM `client` WHERE `id_client`="+cm.data.get(l).getIdClient();
	int a =ConnectionDataBase.executeUpdate(req);
	if(a<1)
	{
		JOptionPane.showMessageDialog(null,"suppression echoué!","Erreur",JOptionPane.ERROR_MESSAGE);

	}
	cm.supprimerLigne(l);
	}
	public void ajouterClient(Client c) {
		String req="INSERT INTO `client`( `ncin`, `nom`, `prenom`, `dateclient`, `adresse`, `ville`, `tel`, `email`, `matricule_fiscale`, `num_reg_commercial`) VALUES ('"+c.getCin()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getDateclient()+"','"+c.getAdresse()+"','"+c.getVille()+"','"+c.getTel()+"','"+c.getEmail()+"','"+c.getMatricule_fiscale()+"','"+c.getNum_reg_commerciale()+"')";
		//ConnectionDataBase.executeUpdate(req);
		String rech="SELECT * FROM `client` WHERE `ncin`='"+c.getCin()+"'"+"and `nom`='"+c.getNom()+"'"+"and `prenom`='"+c.getPrenom()+"'"+"and `matricule_fiscale`='"+c.getMatricule_fiscale()+"'"+"and `num_reg_commercial`='"+c.getNum_reg_commerciale()+"'"+"and `tel`='"+c.getTel()+"'"+"and `email`='"+c.getEmail()+"'";
				try {
		ResultSet rs=ConnectionDataBase.executeQuery(rech);
		
		if(rs.next())
		
			{JOptionPane.showMessageDialog(null," existe deja un client de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
			
			}
		else {ConnectionDataBase.executeUpdate(req);
		ResultSet rs1=ConnectionDataBase.executeQuery(rech);
		rs1.next();
		c.setIdClient(rs1.getInt(1));
		System.out.println(rs1.getInt(1));
        
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		cm.ajouterLigne(c);
	}
	
	public ResultSet affiche()
	{  ResultSet rs=null;
		rs=ConnectionDataBase.executeQuery("select * from client");
		return rs;
	}
	
	public ResultSet rechercheByID(int id)
	{
		return ConnectionDataBase.executeQuery("select * from client where id_client="+id);
	}
	public ResultSet rechercheByNcin(String nc)
	{
		return ConnectionDataBase.executeQuery("select * from client where ncin='"+nc+"'");
	}
	public ResultSet rechercheByVille(String s)
	{
		return ConnectionDataBase.executeQuery("select * from client where ville="+s);
	}
	
	public void modifierClient(Client c)
	{
		String modifreq="UPDATE `client` SET `ncin`='"+c.getCin()+"',`nom`='"+c.getNom()+"',`prenom`='"+c.getPrenom()+"',`dateclient`='"+c.getDateclient()+"',`adresse`='"+c.getAdresse()+"',`ville`='"+c.getVille()+"',`tel`='"+c.getTel()+"',`email`='"+c.getEmail()+"',`matricule_fiscale`='"+c.getMatricule_fiscale()+"',`num_reg_commercial`='"+c.getNum_reg_commerciale()+"' WHERE `id_client`="+c.getIdClient();
       int x= ConnectionDataBase.executeUpdate(modifreq);
     
       
       cm.ModifierLigne(c);
        
      
	}
	
}
