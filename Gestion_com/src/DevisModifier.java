import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ArticleBase;
import ControlerPack.ConnectionDataBase;
import ControlerPack.Ligne_venteBase;
import classPack.Article;
import classPack.Devis;
import classPack.Ligne_vente;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DevisModifier extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Ligne_venteBase db_lignevente;
	private ResultSet rslignevente;
	private ArticleBase db_article;
	private Article article;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DevisModifier(Devis devis) {
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		db_article=new ArticleBase();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 675, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		db_lignevente=new Ligne_venteBase();
		table=new JTable(db_lignevente.mytablemodel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 639, 233);
		contentPane.add(scrollPane);
		initialeJtable(devis);
	}

	private void initialeJtable(Devis devis) {
		rslignevente=ConnectionDataBase.executeQuery("select * from ligne_vente where id_doc_vente= "+devis.getId_doc_vente());
		try {
			while(rslignevente.next())
			{
			article=db_article.rechercheByID(rslignevente.getInt("id_article"));
			
				//Ligne_vente lignev=new Ligne_vente(rslignevente.getInt(1),rslignevente.getFloat(2),rslignevente.getFloat(3),rslignevente.getFloat(4),rslignevente.getInt(5),article);
				Ligne_vente lignev=new Ligne_vente(0,1,0,article.getPrixTTc(),100,article);

				db_lignevente.mytablemodel.AjouterLigne(lignev);
				//lignev=db_ligneVente.AjoutLigne_vente(lignev);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
