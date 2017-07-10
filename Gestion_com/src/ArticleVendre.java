import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ControlerPack.ConnectionDataBase;
import classPack.Article;

import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArticleVendre extends JFrame {

	private JPanel contentPane;
	private JTextField textDesignation;
	private JTextField textReference;
	private JTextField textPrixUnitaire;
	private JTextField textPrixTTC;
	private JTextField textQteStock;
	private JTextField textQteMin;
	private JTextField textTaxe;
	private JTextField textFamille;
	private JTextField textCodeAbarre;
	private JTextField textQteVendu;
	private JTextField textRemise;
	private JTextField textTotal;
	
	/**
	 * Launch the application.
	 */
	private ResultSet rechFamille;
	private String famille;
	private ResultSet rechTaxe;
	private float tauxTaxe;
	private JTextField textTaxez;
	

	/**
	 * Create the frame.
	 */
	public ArticleVendre(Article article) {
				setTitle("Vendre Article");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "D\u00E9taills Article", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setBounds(8, 11, 292, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textDesignation = new JTextField();
		textDesignation.setEditable(false);
		textDesignation.setBounds(10, 21, 272, 29);
		panel.add(textDesignation);
		textDesignation.setColumns(10);
		
		JLabel lblRference = new JLabel("R\u00E9f\u00E9rence :");
		lblRference.setBounds(8, 69, 86, 22);
		panel.add(lblRference);
		
		textReference = new JTextField();
		textReference.setEditable(false);
		textReference.setBounds(91, 65, 191, 29);
		panel.add(textReference);
		textReference.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Prix Untaire :");
		lblNewLabel.setBounds(8, 109, 86, 22);
		panel.add(lblNewLabel);
		
		textPrixUnitaire = new JTextField();
		textPrixUnitaire.setEditable(false);
		textPrixUnitaire.setBounds(91, 105, 191, 29);
		panel.add(textPrixUnitaire);
		textPrixUnitaire.setColumns(10);
		
		JLabel lblPrixTtc = new JLabel("Prix TTC :");
		lblPrixTtc.setBounds(8, 149, 66, 22);
		panel.add(lblPrixTtc);
		
		textPrixTTC = new JTextField();
		textPrixTTC.setEditable(false);
		textPrixTTC.setBounds(91, 145, 191, 29);
		panel.add(textPrixTTC);
		textPrixTTC.setColumns(10);
		
		JLabel lblQteStock = new JLabel("Qte Stock :");
		lblQteStock.setBounds(8, 189, 72, 22);
		panel.add(lblQteStock);
		
		textQteStock = new JTextField();
		textQteStock.setEditable(false);
		textQteStock.setBounds(91, 185, 191, 29);
		panel.add(textQteStock);
		textQteStock.setColumns(10);
		
		JLabel lblQteMin = new JLabel("Qte Min :");
		lblQteMin.setBounds(8, 229, 61, 22);
		panel.add(lblQteMin);
		
		textQteMin = new JTextField();
		textQteMin.setEditable(false);
		textQteMin.setBounds(91, 225, 191, 29);
		panel.add(textQteMin);
		textQteMin.setColumns(10);
		
		JLabel lblTaxe = new JLabel("Taxe :");
		lblTaxe.setBounds(8, 269, 72, 22);
		panel.add(lblTaxe);
		
		textTaxe = new JTextField();
		textTaxe.setEditable(false);
		textTaxe.setText("");
		textTaxe.setBounds(91, 265, 191, 29);
		panel.add(textTaxe);
		textTaxe.setColumns(10);
		
		JLabel lblFamille = new JLabel("Famille :");
		lblFamille.setBounds(10, 309, 72, 22);
		panel.add(lblFamille);
		
		textFamille = new JTextField();
		textFamille.setEditable(false);
		textFamille.setBounds(91, 305, 191, 29);
		panel.add(textFamille);
		textFamille.setColumns(10);
		
		JLabel lblCodeAbarre = new JLabel("Code Abarre :");
		lblCodeAbarre.setBounds(8, 349, 86, 22);
		panel.add(lblCodeAbarre);
		
		textCodeAbarre = new JTextField();
		textCodeAbarre.setEditable(false);
		textCodeAbarre.setBounds(91, 345, 191, 29);
		panel.add(textCodeAbarre);
		textCodeAbarre.setColumns(10);
		 rechFamille=ConnectionDataBase.executeQuery("select * from famille where id_famille="+article.getId_famille());
		try {
			rechFamille.next();
			 famille=rechFamille.getString(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 rechTaxe=ConnectionDataBase.executeQuery("select * from taxe where id_taxe="+article.getId_taxe());
			try {
				rechTaxe.next();
				 tauxTaxe=rechTaxe.getFloat(3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		textDesignation.setText(article.getDesignation());
		textReference.setText(article.getReference());
		textPrixUnitaire.setText( String.valueOf(article.getPrix_unitaire()));
		textPrixTTC.setText( String.valueOf(article.getPrixTTc()));
		textQteStock.setText(String.valueOf(article.getQuantiteStock()));
		textQteMin.setText(String.valueOf(article.getQuantiteMin()));
		textCodeAbarre.setText(article.getCodeAbarre());
		textFamille.setText(famille);
		textTaxe.setText(String.valueOf(tauxTaxe));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detaills Vente", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_1.setBounds(312, 11, 312, 387);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 :");
		lblQuantit.setBounds(10, 28, 77, 38);
		panel_1.add(lblQuantit);
		
		textQteVendu = new JTextField("1");
		textQteVendu.setBounds(102, 28, 179, 38);
		panel_1.add(textQteVendu);
		textQteVendu.setColumns(10);
		textQteVendu.setInputVerifier(new FloatVerifier());
		JLabel lblRemi = new JLabel("Remise % :");
		lblRemi.setBounds(10, 108, 72, 33);
		panel_1.add(lblRemi);
		
		textRemise = new JTextField("0");
		textRemise.setBounds(102, 102, 179, 38);
		textRemise.setInputVerifier(new FloatVerifier());
		panel_1.add(textRemise);
		textRemise.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Taxe  % :");
		lblNewLabel_1.setBounds(10, 171, 64, 38);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblTotalTtc = new JLabel("Total TTC :");
		lblTotalTtc.setBounds(10, 234, 77, 38);
		panel_1.add(lblTotalTtc);
		
		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setBounds(102, 234, 179, 38);
		panel_1.add(textTotal);
		textTotal.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(64, 329, 89, 33);
		panel_1.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnAnnuler.setBounds(180, 329, 89, 33);
		panel_1.add(btnAnnuler);
		
		textTaxez = new JTextField();
		textTaxez.setBounds(102, 171, 179, 38);
		panel_1.add(textTaxez);
		textTaxez.setText(String.valueOf(tauxTaxe));
		textTaxez.setColumns(10);
		textTaxez.setInputVerifier(new FloatVerifier());
	}
}
