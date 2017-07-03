import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.TaxeBase;
import classPack.Taxe;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxeModifier extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldlibelle;
	private JTextField textField_taux;


	/**
	 * Create the frame.
	 */
	public TaxeModifier(Taxe t) {
		setTitle("Modifier taxe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 332, 286);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibell = new JLabel("Libell\u00E9 :");
		lblLibell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLibell.setBounds(33, 49, 75, 37);
		contentPane.add(lblLibell);
		
		textFieldlibelle = new JTextField();
		textFieldlibelle.setBounds(118, 49, 125, 30);
		contentPane.add(textFieldlibelle);
		textFieldlibelle.setColumns(10);
		
		JLabel lblTaux = new JLabel("Taux");
		lblTaux.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaux.setBounds(33, 110, 54, 30);
		contentPane.add(lblTaux);
		
		textField_taux = new JTextField();
		textField_taux.setBounds(118, 110, 125, 30);
		contentPane.add(textField_taux);
		textField_taux.setColumns(10);
		
		textFieldlibelle.setText(t.getLibelle());
		textField_taux.setText(String.valueOf(t.getTaux()) );
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxeBase db_taxe=new TaxeBase();
				
				t.setLibelle(textFieldlibelle.getText());
				t.setTaux(Float.parseFloat(textField_taux.getText()));
				db_taxe.ModifierTaxe(t);
				dispose();
				
			}
		});
		btnModifier.setBounds(92, 191, 89, 34);
		contentPane.add(btnModifier);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setBounds(209, 191, 89, 34);
		contentPane.add(btnAnnuler);
	}
}