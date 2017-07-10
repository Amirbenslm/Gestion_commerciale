import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import ControlerPack.ArticleBase;

import ControlerPack.FamilleBase;
import ControlerPack.TaxeBase;
import classPack.Article;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ArticleModifier extends JFrame {

	private JPanel contentPane;
	private JTextField designation;
	private JTextField reference;
	private JTextField prixunitaire;
	private JTextField prixTTC;
	private JTextField codeAbarre;
	private JTextField QteStock;
	private JTextField QteMin;
	private Article artiModifier;
	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleModifier frame = new ArticleModifier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public  ArticleModifier(ArticleBase db_article,Article a1,TableModel rechmodel) {
		// TODO Auto-generated constructor stub
	artiModifier=a1;
		setVisible(true);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modifier article", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setBounds(10, 11, 597, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Designation");
		lblNewLabel.setBounds(20, 34, 78, 30);
		panel.add(lblNewLabel);
		
		designation = new JTextField();
		designation.setBounds(139, 34, 440, 30);
		panel.add(designation);
		designation.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 87, 238, 189);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(4,2, 0, 30));
		
		JLabel lblNewLabel_1 = new JLabel("R\u00E9ference");
		panel_1.add(lblNewLabel_1);
		
		reference = new JTextField();
		panel_1.add(reference);
		reference.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prix Unitaire");
		panel_1.add(lblNewLabel_2);
		
		prixunitaire = new JTextField();
		panel_1.add(prixunitaire);
		prixunitaire.setColumns(10);
		prixunitaire.setInputVerifier(new FloatVerifier());
		
		JLabel lblNewLabel_3 = new JLabel("Prix TTC");
		panel_1.add(lblNewLabel_3);
		
		prixTTC = new JTextField();
		panel_1.add(prixTTC);
		prixTTC.setColumns(10);
		prixTTC.setInputVerifier(new FloatVerifier());
		
		JLabel lblNewLabel_4 = new JLabel("Code Abarre");
		panel_1.add(lblNewLabel_4);
		
		codeAbarre = new JTextField();
		panel_1.add(codeAbarre);
		codeAbarre.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(314, 87, 265, 189);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 0, 30));
		
		JLabel lblNewLabel_5 = new JLabel("Quantit\u00E9 en stock");
		panel_2.add(lblNewLabel_5);
		
		QteStock = new JTextField();
		panel_2.add(QteStock);
		QteStock.setColumns(10);
		QteStock.setInputVerifier(new FloatVerifier());
		
		JLabel lblNewLabel_7 = new JLabel("Quantit\u00E9 minimum");
		panel_2.add(lblNewLabel_7);
		
		QteMin = new JTextField();
		panel_2.add(QteMin);
		QteMin.setColumns(10);
		QteMin.setInputVerifier(new FloatVerifier());
		JLabel lblNewLabel_8 = new JLabel("Taxe");
		panel_2.add(lblNewLabel_8);
		
		JComboBox<String> cb_taxe = new JComboBox<String>();
		panel_2.add(cb_taxe);
		TaxeBase db_taxe=new TaxeBase();
		ResultSet rstaxe=db_taxe.affiche();
		try {
			while(rstaxe.next())
			{
			cb_taxe.addItem(rstaxe.getString(2));	
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_6 = new JLabel("Famille");
		panel_2.add(lblNewLabel_6);
		
		JComboBox<String> cb_famille = new JComboBox<String>();
		panel_2.add(cb_famille);
		FamilleBase db_fammile=new FamilleBase();
		ResultSet rsFamille=db_fammile.affiche();
		try {
			while(rsFamille.next())
			{
			cb_famille.addItem(rsFamille.getString(2));	
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		designation.setText(a1.getDesignation());
		reference.setText(a1.getReference());
		prixTTC.setText(String.valueOf(a1.getPrixTTc()));
		prixunitaire.setText(String.valueOf(a1.getPrix_unitaire()));
		QteMin.setText(String.valueOf(a1.getQuantiteMin()));
		QteStock.setText(String.valueOf(a1.getQuantiteStock()));
		codeAbarre.setText(a1.getCodeAbarre());
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_famille = 0,id_taxe = 0;
				String famille=cb_famille.getSelectedItem().toString();
				String taxe=cb_taxe.getSelectedItem().toString();
				ResultSet rsidfammile=db_fammile.rechercheByNomFamille(famille);
				
				try {
					rsidfammile.next();
				
					 id_famille =rsidfammile.getInt(1);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rsidtaxe=db_taxe.rechercheByLibille(taxe);
				try {
					rsidtaxe.next();
				
				id_taxe=rsidtaxe.getInt(1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				artiModifier.setId_famille(id_famille);
				artiModifier.setId_taxe(id_taxe);
				artiModifier.setReference(reference.getText());
				artiModifier.setDesignation(designation.getText());
				artiModifier.setPrix_unitaire(Float.parseFloat(prixunitaire.getText()));
				artiModifier.setPrixTTc(Float.parseFloat(prixTTC.getText()));
				artiModifier.setCodeAbarre(codeAbarre.getText());
				artiModifier.setQuantiteMin(Float.parseFloat(QteMin.getText()));
				artiModifier.setQuantiteStock(Float.parseFloat(QteStock.getText()));
		
				db_article.ModifierArticle(artiModifier);
				//rechmodel.
			dispose();	
			}
		});
		btnModifier.setBounds(346, 309, 89, 34);
		contentPane.add(btnModifier);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				dispose();
			}
		});
		btnAnnuler.setBounds(474, 309, 96, 34);
		contentPane.add(btnAnnuler);
	}
}
