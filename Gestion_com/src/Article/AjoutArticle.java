package Article;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AjoutArticle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblFamille;
	private JLabel lblCodeabarre;
	private JLabel lblTaxe;
	private JPanel panel_1;
	private JTextField textField_6;
	private JButton btnAjouter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutArticle frame = new AjoutArticle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AjoutArticle() {
		setTitle("Ajouter Article");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 12, 124, 278);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(9, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("R\u00E9f\u00E9rence");
		panel.add(lblNewLabel);
		
		JLabel lblDsignation = new JLabel("D\u00E9signation");
		panel.add(lblDsignation);
		
		lblFamille = new JLabel("Famille");
		panel.add(lblFamille);
		
		JLabel lblPrixUnitaire = new JLabel("Prix Unitaire");
		panel.add(lblPrixUnitaire);
		
		JLabel lblPrixTtc = new JLabel("Prix TTC");
		panel.add(lblPrixTtc);
		
		JLabel lblQteEnStock = new JLabel("Qte en Stock");
		panel.add(lblQteEnStock);
		
		JLabel lblQteMinimum = new JLabel("Qte Minimum");
		panel.add(lblQteMinimum);
		
		lblCodeabarre = new JLabel("CodeAbarre");
		panel.add(lblCodeabarre);
		
		lblTaxe = new JLabel("Taxe");
		panel.add(lblTaxe);
		
		panel_1 = new JPanel();
		panel_1.setBounds(144, 12, 200, 278);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(9, 0, 0, 5));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(417, 310, 89, 23);
		contentPane.add(btnAjouter);
	}
}
