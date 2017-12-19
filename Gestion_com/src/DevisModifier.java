
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DevisModifier extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Ligne_venteBase db_lignevente;
	private ResultSet rslignevente;
	private Article article;
	private JTextField textField;
	protected ResultSet rsarticle;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DevisModifier(Devis devis) {
		
		this.setTitle(devis.getReference());
		new ArticleBase();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 835, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 799, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 25, 129, 30);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Code Abarre", "Designation", "Reference"}));
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Code Abarre"))
				{rsarticle=ConnectionDataBase.executeQuery("select * from article where code_abar='"+textField.getText()+"'");}
				if(comboBox.getSelectedItem().equals("Designation"))
				{rsarticle=ConnectionDataBase.executeQuery("select * from article where designation='"+textField.getText()+"'");}
				if(comboBox.getSelectedItem().equals("Reference"))
				{rsarticle=ConnectionDataBase.executeQuery("select * from article where reference='"+textField.getText()+"'");}
				
				try {
				if(rsarticle.next())
				{
			
					
			article=new Article(rsarticle.getInt(1),rsarticle.getString(2),rsarticle.getString(3),rsarticle.getDouble(4),rsarticle.getDouble(5),rsarticle.getFloat(6),rsarticle.getFloat(7),rsarticle.getString(8),rsarticle.getInt(9),rsarticle.getInt(10));
			
				Ligne_vente lignev=new Ligne_vente(0,1,0,article.getPrixTTc(), devis.getId_doc_vente(),article);
				
				
				lignev=db_lignevente.AjoutLigne_vente(lignev);
				
				
				}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			 }
			}
		});
		textField.setBounds(165, 25, 222, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSupprimerLigne = new JButton("Supprimer ligne");
		btnSupprimerLigne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{int i=JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                        "Veuillez confirmer votre choix",
                        JOptionPane.YES_NO_OPTION);
				 	if(i==0){
				 		
					db_lignevente.supprimerLigne_vente(db_lignevente.mytablemodel.getLigneVente(table.getSelectedRow()).getId_ligneVente());
					}}
			else
			{JOptionPane.showMessageDialog(null,"Il faut sélectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
		});
		btnSupprimerLigne.setBounds(610, 25, 129, 30);
		panel.add(btnSupprimerLigne);
		db_lignevente=new Ligne_venteBase();
		table=new JTable();
		initialeJtable(devis);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(10, 96, 799, 334);
		contentPane.add(scrollPane);
		
	}

	private void initialeJtable(Devis devis) {
		
		rslignevente=ConnectionDataBase.executeQuery("select * from ligne_vente l,article a where  l.id_doc_vente= "+devis.getId_doc_vente()+" and l.id_article=a.id_article");
		try {
			while(rslignevente.next())
			{
		
				Article article=new Article(rslignevente.getInt("id_article"),rslignevente.getString("reference"),rslignevente.getString("designation"),rslignevente.getDouble("prix_unitaire"),rslignevente.getDouble("prix_TTC"),10,12,"codeAbarre",1,1);

				Ligne_vente lignev=new Ligne_vente(rslignevente.getInt("id_ligneVente"),rslignevente.getFloat(2),rslignevente.getFloat(3),rslignevente.getFloat(4),rslignevente.getInt(5),article);
		table.setModel(db_lignevente.mytablemodel);
				db_lignevente.mytablemodel.AjouterLigne(lignev);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
