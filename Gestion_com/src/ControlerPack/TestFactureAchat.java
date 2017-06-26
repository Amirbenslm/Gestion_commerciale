package ControlerPack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import classPack.Client;
import classPack.Facture_Achat;

public class TestFactureAchat extends JFrame implements MouseListener,ActionListener{

	ConnectionDataBase cdb=null; 
	public FactureAchatBase factureAchatBase=null;
	JTable jtfacture;JScrollPane jsp;JButton bmodif;
	public TestFactureAchat()
	{   this.setTitle("gestion des factures d'achat");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
			
				ConnectionDataBase.deconnection();
			}
			public void windowClosed(WindowEvent arg0) {
			
				ConnectionDataBase.deconnection();
			}
		});
	    jtfacture = new JTable();
		cdb=new ConnectionDataBase();
		  chargerConnexion();
          initJtableFacture();			
			jsp=new JScrollPane(jtfacture);
			jtfacture.addMouseListener(this);
			bmodif =new JButton("modifier");
			bmodif.addActionListener(this);
			this.add(jsp,BorderLayout.CENTER);
			this.add(bmodif,BorderLayout.SOUTH);
			
	}
	 public void chargerConnexion()
		{
			ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
			
			
			ConnectionDataBase.connect("jdbc:mysql://localhost/gestioncommercial","root","");
		}
	 
	 void initJtableFacture() {
		 String req="SELECT * FROM `facture_achat`";
		ResultSet rs=ConnectionDataBase.executeQuery(req);
		 factureAchatBase=new FactureAchatBase(rs);
		 					jtfacture.setModel(factureAchatBase.fam);
			
			
		}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Debut de programme");
		 TestFactureAchat f=new TestFactureAchat();
		
	
        f.setVisible(true);
		System.out.println("Fin de programme"); 

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jtfacture)
		{
			if(arg0.getModifiers()==InputEvent.BUTTON1_MASK)
			{ //mytablemodel.supprimerLigne(jtclient.getSelectedRow());
             Facture_Achat f1=new Facture_Achat(1, "dd", 1, 1, 1, 1);
              factureAchatBase.ajouterFactureAchat(f1);
				
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==bmodif)
		{   Facture_Achat f =new Facture_Achat(4,"reference",10,10,10,2);
			factureAchatBase.supprimerFactureAchat(f.getId_factureAchat());
      
		}
		
	}
	


}
