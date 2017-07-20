package ControlerPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import classPack.Bon_livraison_vente;
import classPack.Devis;


public class TestDevis extends JFrame implements MouseListener{
DevisBase cdb=null; 
	
	JTable jtclient;
	JScrollPane jsp;

	public  TestDevis()
	{
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
	
		this.setTitle("gestion des Devis");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
				
			ConnectionDataBase.deconnection();
			}});

	    jtclient = new JTable();
	   
	    
	    
		cdb=new DevisBase();
		
		  intitJtableClient();
			
			jsp=new JScrollPane(jtclient);
			jtclient.addMouseListener(this);
			JButton ajout=new JButton("Ajouter");
			ajout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Devis f=new Devis(1,"REference",1,0);
					cdb.AjoutDevis(f);
					ResultSet rech=	cdb.rechercheByReference("REference");
				try {
					while(rech.next())
					{System.out.println(rech.getString(1));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
			JButton modifier=new JButton("Modifier");
			modifier.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Devis f=new Devis(19,"REferenceModifier",1,7);
					cdb.ModifierDevis(f);
					}
			});
			this.setLayout(null);
			
			ajout.setBounds(120,350,80,40);
			modifier.setBounds(220,350,80,40);
			jsp.setBounds(0,0,1200,350);
			this.add(jsp);
			this.add(ajout);this.add(modifier);
	}
	
void intitJtableClient() {
	
	
jtclient.setModel(cdb.mytablemodel);
			
	
	
}
public static void main(String []args)
{
	System.out.println("Debut de programme");
	 TestDevis c=new TestDevis();
	 c.setVisible(true);
	System.out.println("Fin de programme"); 

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jtclient)
	cdb.supprimerDevis((int)cdb.mytablemodel.getValueAt(jtclient.getSelectedRow(),0));
	
	
	 	
			
		}
	

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
