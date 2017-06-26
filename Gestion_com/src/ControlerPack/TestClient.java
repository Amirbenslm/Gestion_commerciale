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

public class TestClient  extends JFrame implements MouseListener,ActionListener{

	ConnectionDataBase cdb=null; 
	public ClientBase clientBase=null;
	JTable jtclient;JScrollPane jsp;JButton bmodif;
	public TestClient()
	{   this.setTitle("gestion des clients");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
				//ConnectionDataBase.closeStatement();
				ConnectionDataBase.deconnection();
			}
			public void windowClosed(WindowEvent arg0) {
				//ConnectionDataBase.closeStatement();
				ConnectionDataBase.deconnection();
			}
		});
	    jtclient = new JTable();
		cdb=new ConnectionDataBase();
		  chargerConnexion();
		  intitJtableClient();
			
			jsp=new JScrollPane(jtclient);
			jtclient.addMouseListener(this);
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
	 
	 void intitJtableClient() {
		 String req="SELECT * FROM `client`";
		ResultSet rs=ConnectionDataBase.executeQuery(req);
		 clientBase=new ClientBase(rs);
		 					jtclient.setModel(clientBase.cm);
			
			
		}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Debut de programme");
		 TestClient c=new TestClient();
		
	
        c.setVisible(true);
		System.out.println("Fin de programme"); 

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jtclient)
		{
			if(arg0.getModifiers()==InputEvent.BUTTON1_MASK)
			{ //mytablemodel.supprimerLigne(jtclient.getSelectedRow());
			 Client cl=new Client(0,"ben salem", "amire", "09874563", "2014-05-02", "nabeul", "nabeul","5482", "58a4s","21456354", "amir@gmail.com");
		        clientBase.ajouterClient(cl);;
				
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
		{Client c=new Client(4, "p", "opppze", "04978785", "1969-08-04", "d", "vi", "mtricule_fiscale", "num_reg_commerciale", "tel", "email");
			clientBase.modifierClient(c);
			
		}
		
	}
	


}
