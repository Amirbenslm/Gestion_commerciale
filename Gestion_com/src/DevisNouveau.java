import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ArticleVendueModel;
import ControlerPack.ConnectionDataBase;
import ControlerPack.DevisBase;
import ControlerPack.Document_venteBase;
import ControlerPack.Ligne_venteBase;
import ControlerPack.PaiementModel;
import classPack.Article;
import classPack.ArticleVendue;
import classPack.Devis;
import classPack.Document_vente;
import classPack.Ligne_vente;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class DevisNouveau extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField textField;
	private Document_vente document;
	protected ResultSet rsarticle;
	private JTable table;
	protected Article article;
	protected Ligne_venteBase db_ligneVente;
	
	ArticleVendueModel articleModel=new ArticleVendueModel();
	private JLabel lbNomClient;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param db_devis 
	 */
	public DevisNouveau(DevisBase db_devis) {
		setResizable(false);
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dat = dateFormat.format(actuelle);
		 document=new Document_vente(0, dat,"D",2);
		Document_venteBase db_docVente=new Document_venteBase();
		document=db_docVente.AjoutDocument_vente(document);
		
		Devis devis=new Devis(0,"Devis"+document.getId_documentV(),document.getId_documentV(),0);
		
		db_devis.AjoutDevis(devis);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 754, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 728, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Code Abarre", "Designation", "Reference"}));
		comboBox.setBounds(10, 27, 129, 30);
		panel.add(comboBox);
		db_ligneVente =new Ligne_venteBase();
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
			
				Ligne_vente lignev=new Ligne_vente(0,1,0,article.getPrixTTc(), document.getId_documentV(),article);
				
				
				lignev=db_ligneVente.AjoutLigne_vente(lignev);
				
				
				}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			 }
			}
		});
		textField.setBounds(164, 27, 231, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnClient = new JButton("Client");
		btnClient.setBackground(SystemColor.controlHighlight);
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ListesClients(document.getId_documentV(),lbNomClient).setVisible(true);
			}
		});
		btnClient.setBounds(571, 27, 136, 30);
		panel.add(btnClient);
		table=new JTable();
		table.setModel(db_ligneVente.mytablemodel);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.textHighlight));
		scrollPane.setBounds(10, 134, 728, 317);
		contentPane.add(scrollPane);
		
		 lbNomClient = new JLabel("");
		lbNomClient.setBounds(10, 98, 357, 25);
		contentPane.add(lbNomClient);
		
		JButton btnSupprimerLigne = new JButton("Supprimer ligne");
		btnSupprimerLigne.setBackground(SystemColor.controlHighlight);
		btnSupprimerLigne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{int i=JOptionPane.showConfirmDialog(null, "La suppression est irr�versible. �tes-vous s�r de vouloir continuer?",
                        "Veuillez confirmer votre choix",
                        JOptionPane.YES_NO_OPTION);
				 	if(i==0){
				 		
					db_ligneVente.supprimerLigne_vente(db_ligneVente.mytablemodel.getLigneVente(table.getSelectedRow()).getId_ligneVente());
					}}
			else
			{JOptionPane.showMessageDialog(null,"Il faut s�lectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
		});
		btnSupprimerLigne.setBounds(586, 98, 138, 30);
		contentPane.add(btnSupprimerLigne);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2)
		{
			Ligne_vente artvendre=db_ligneVente.mytablemodel.getLigneVente(table.getSelectedRow());
			ArticleVendre art=new ArticleVendre(artvendre);
			art.setVisible(true);
		}
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
