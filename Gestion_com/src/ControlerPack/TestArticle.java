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
import classPack.Fournisseur;

public class TestArticle extends JFrame implements MouseListener{
	ArticleBase cdb=null; 
	public ArticleModel mytablemodel=null;
	JTable jtarticle;
	JScrollPane jsp;
	 public TestArticle() {

	{
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
	
		this.setTitle("gestion des Articles");
	    this.setSize(1300,500);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
			
	    jtarticle = new JTable();
		cdb=new ArticleBase();
		jtarticle.setModel(cdb.mytablemodel);			
			jsp=new JScrollPane(jtarticle);
			jtarticle.addMouseListener(this);
			JButton ajout=new JButton("Ajouter");
			ajout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Article f=new Article(0, "referencea22", "designationAjout",10,10,10,12,"codeAbarre",1,1);
					cdb.AjoutArticle(f);				
				ResultSet rech=	cdb.rechercheByReference("reference");
				try {
					while(rech.next())
					{System.out.println(rech.getString(2));
						
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
					Article f=new Article(10, "referenceModifier125", "designation555555zzzz",10,10,10,12,"codeAbarre",1,1);
					cdb.ModifierArticle(f);
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
public static void main(String []args)
{
	System.out.println("Debut de programme");
	 TestArticle c=new TestArticle();
	 c.setVisible(true);
	System.out.println("Fin de programme"); 

}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jtarticle)
		
	cdb.supprimerArticle(14);
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
