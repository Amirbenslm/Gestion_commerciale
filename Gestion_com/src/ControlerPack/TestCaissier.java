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

import classPack.Article;
import classPack.Caissier;
import classPack.Famille;
import classPack.Fournisseur;

public class TestCaissier extends JFrame implements MouseListener{
	CaissierBase cdb=null; 
	public CaissierModel mytablemodel=null;
	JTable jtCaissier;
	JScrollPane jsp;
	 public TestCaissier() {
		 ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		 ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");	
	{
		this.setTitle("gestion des Caissier");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);	
	    jtCaissier = new JTable();
		cdb=new CaissierBase();
		  intitJtableFamille();	
			jsp=new JScrollPane(jtCaissier);
			jtCaissier.addMouseListener(this);
			JButton ajout=new JButton("Ajouter");
			ajout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Caissier f=new Caissier(0,"ncin","nom","prenom","adresse","ville","telephone","login","pwd");
					cdb.AjoutCaissier(f);				
				ResultSet rech=	cdb.rechercheByNCIN("fam1");
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
					Caissier f=new Caissier(1,"ncinMod","nom","prenom","adresse","ville","telephone","login","pwd");
					cdb.ModifierCAissier(f);
					}
			});
			this.setLayout(null);
			ajout.setBounds(120,350,80,40);
			modifier.setBounds(220,350,80,40);
			jsp.setBounds(0,0,1200,350);
			this.add(jsp);
			this.add(ajout);
			this.add(modifier);
	}
	}
	
void intitJtableFamille() {
	
			
			jtCaissier.setModel(cdb.mytablemodel);
	
	
}
public static void main(String []args)
{
	System.out.println("Debut de programme");
	 TestCaissier c=new TestCaissier();
	 c.setVisible(true);
	System.out.println("Fin de programme"); 

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jtCaissier)
	cdb.supprimerCaissier((int)cdb.mytablemodel.getValueAt(jtCaissier.getSelectedRow(),0));	
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
