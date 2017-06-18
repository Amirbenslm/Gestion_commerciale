package ControlerPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import classPack.Fournisseur;

public class TestFournisseur extends JFrame implements MouseListener{
	FournisseurBase cdb=null; 
	public FournisseurModel mytablemodel=null;
	JTable jtclient;
	JScrollPane jsp;
	public TestFournisseur()
	{
		this.setTitle("gestion des clients");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
				//ConnectionDataBase.closeStatement();
				//ConnectionDataBase.deconnection();
			}});

	    jtclient = new JTable();
	   
	    
	    
		cdb=new FournisseurBase();
		
		  intitJtableClient();
			
			jsp=new JScrollPane(jtclient);
			jtclient.addMouseListener(this);
			JButton ajout=new JButton("Ajouter");
			ajout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//Fournisseur f=new Fournisseur(16, "reference5555", "rason_social991", "adresse88", "ville88", "matricule_fiscale88", "num_reg_commerciale88", "num_tel88");
					//Fournisseur newid=cdb.AjoutFournisseur(f);
					//cdb.ModifierFournisseur(f);
					//if (newid!=null) {mytablemodel.AjouterLigne(newid);}
					//mytablemodel.ModifierLigne(jtclient.getSelectedRow(), f);
				ResultSet rech=	cdb.rechercheByVille("ville88");
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
			this.setLayout(null);
			ajout.setBounds(120,350,80,40);
			jsp.setBounds(0,0,1200,350);
			this.add(jsp);
			this.add(ajout);
	}
	
void intitJtableClient() {
	String req="SELECT * FROM `client`";
			ResultSet rs=cdb.affiche();
int i=0;
		
			mytablemodel=new FournisseurModel(rs);
			System.out.println(mytablemodel.getColumnCount());
			System.out.println(mytablemodel.getRowCount());
			//System.out.println(mytablemodel.getValueAt(3, 2));
			jtclient.setModel(mytablemodel);
	
	
}
public static void main(String []args)
{
	System.out.println("Debut de programme");
	 TestFournisseur c=new TestFournisseur();
	 c.setVisible(true);
	System.out.println("Fin de programme"); 

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jtclient)
		System.out.println(jtclient.getSelectedRow());
	System.out.println( mytablemodel.getValueAt(jtclient.getSelectedRow(),0));
	cdb.supprimerFourisseur((int)mytablemodel.getValueAt(jtclient.getSelectedRow(),0));
	 mytablemodel.supprimerLigne(jtclient.getSelectedRow());
	
	 	
			
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
