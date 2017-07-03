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

public class TaxeAjout extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldlibelle;
	private JTextField textField_taux;


	/**
	 * Create the frame.
	 */
	public TaxeAjout() {
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
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxeBase db_taxe=new TaxeBase();
				Taxe t=new Taxe(0,textFieldlibelle.getText(),Float.parseFloat(textField_taux.getText()));
				db_taxe.AjoutTaxe(t);
				Taxes.model.fireTableDataChanged();
			}
		});
		btnAjouter.setBounds(92, 191, 89, 34);
		contentPane.add(btnAjouter);
		
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
