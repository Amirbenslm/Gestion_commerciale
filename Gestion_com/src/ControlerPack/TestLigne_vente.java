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

import classPack.Article;
import classPack.Ligne_vente;





public class TestLigne_vente extends JFrame implements MouseListener{
	Ligne_venteBase cdb=null; 
	
	JTable jtclient;
	JScrollPane jsp;

	public TestLigne_vente()
	{
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
	
		this.setTitle("gestion des Ligne_vente");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
				
			ConnectionDataBase.deconnection();
			}});

	    jtclient = new JTable();
	   
	    
	    
		cdb=new Ligne_venteBase();
		
		  intitJtableClient();
			
			jsp=new JScrollPane(jtclient);
			jtclient.addMouseListener(this);
			JButton ajout=new JButton("Ajouter");
			ajout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Ligne_vente f=new Ligne_vente(4, 5, 10, 15, 1,new Article(0, "reference", "designation", 5,1,6,5,"codeAbarre",1, 1));
					cdb.AjoutLigne_vente(f);
					ResultSet rech=	cdb.rechercheByID(1);
				try {
					while(rech.next())
					{//System.out.println(rech.getString(1));
						
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
					//Ligne_vente f=new Ligne_vente(2, 15, 15, 15, 1, 17);
					//cdb.ModifierLigne_vente(f);
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
	 TestLigne_vente c=new TestLigne_vente();
	 c.setVisible(true);
	System.out.println("Fin de programme"); 

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jtclient)
	cdb.supprimerLigne_vente((int)cdb.mytablemodel.getValueAt(jtclient.getSelectedRow(),0));
	
	
	 	
			
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
