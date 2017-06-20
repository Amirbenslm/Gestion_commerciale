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
import classPack.Famille;
import classPack.Fournisseur;

public class TestFamille extends JFrame implements MouseListener{
	FamilleBase cdb=null; 
	public FamilleModel mytablemodel=null;
	JTable jtfamille;
	JScrollPane jsp;
	 public TestFamille() {
		 ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		 ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");	
	{
		this.setTitle("gestion des Famille");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);	
	    jtfamille = new JTable();
		cdb=new FamilleBase();
		  intitJtableFamille();	
			jsp=new JScrollPane(jtfamille);
			jtfamille.addMouseListener(this);
			JButton ajout=new JButton("Ajouter");
			ajout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Famille f=new Famille(0,"Famille1",1);
					Famille newid=cdb.AjoutFamille(f);
					
					if (newid!=null) {mytablemodel.AjouterLigne(newid);}
					
				ResultSet rech=	cdb.rechercheByNomFamille("fam1");
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
					Famille f=new Famille(3,"Famille155555555",1);
					cdb.ModifierFamille(f);
					if(jtfamille.getSelectedRow()==0)
					mytablemodel.ModifierLigne(jtfamille.getSelectedRow()+1,f);
					else
						mytablemodel.ModifierLigne(jtfamille.getSelectedRow(),f);
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
	
			ResultSet rs=cdb.affiche();
			mytablemodel=new FamilleModel(rs);
			jtfamille.setModel(mytablemodel);
	
	
}
public static void main(String []args)
{
	System.out.println("Debut de programme");
	 TestFamille c=new TestFamille();
	 c.setVisible(true);
	System.out.println("Fin de programme"); 

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jtfamille)
		System.out.println(jtfamille.getSelectedRow());
	
	cdb.supprimerFamille((int)mytablemodel.getValueAt(jtfamille.getSelectedRow(),0));
	 mytablemodel.supprimerLigne(jtfamille.getSelectedRow());
	
	 	
			
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
