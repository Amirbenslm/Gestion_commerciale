import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import ControlerPack.FactureBase;
import classPack.Facture;

import java.awt.Color;
import java.awt.SystemColor;

public class FactureModifier extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textReference;
	private JTextField textretourSource;
	private JTextField textTaxeFiscale;
	private JTextField textFodec;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param db_Facture 
	 * @param facture 
	 */
	public FactureModifier(FactureBase db_Facture, Facture facture) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 495, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setBounds(10, 31, 27, 25);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(38, 29, 86, 28);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblReference = new JLabel("R\u00E9ference  :");
		lblReference.setForeground(SystemColor.textHighlight);
		lblReference.setBounds(159, 29, 86, 25);
		contentPane.add(lblReference);
		
		textReference = new JTextField();
		textReference.setEditable(false);
		textReference.setBounds(244, 31, 147, 25);
		contentPane.add(textReference);
		textReference.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 80, 355, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retour \u00E0 Source");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(10, 11, 107, 25);
		panel.add(lblNewLabel);
		
		textretourSource = new JTextField();
		textretourSource.setBounds(127, 11, 117, 25);
		panel.add(textretourSource);
		textretourSource.setColumns(10);
		
		JLabel lblTaxeFiscale = new JLabel("Taxe Fiscale");
		lblTaxeFiscale.setForeground(SystemColor.textHighlight);
		lblTaxeFiscale.setBounds(10, 53, 107, 25);
		panel.add(lblTaxeFiscale);
		
		textTaxeFiscale = new JTextField();
		textTaxeFiscale.setBounds(127, 53, 117, 25);
		panel.add(textTaxeFiscale);
		textTaxeFiscale.setColumns(10);
		
		JLabel lblFodec = new JLabel("Fodec");
		lblFodec.setForeground(SystemColor.textHighlight);
		lblFodec.setBounds(10, 97, 107, 25);
		panel.add(lblFodec);
		
		textFodec = new JTextField();
		textFodec.setBounds(127, 97, 117, 25);
		panel.add(textFodec);
		textFodec.setColumns(10);
		textretourSource.setInputVerifier(new FloatVerifier());
		textTaxeFiscale.setInputVerifier(new FloatVerifier());
		textFodec.setInputVerifier(new FloatVerifier());
		
		textID.setText(String.valueOf(facture.getId_facture()));
		textReference.setText(facture.getReference());
		textretourSource.setText(String.valueOf(facture.getRetour_source()));
		textTaxeFiscale.setText(String.valueOf(facture.getTaxe_fiscale()));
		textFodec.setText(String.valueOf(facture.getFodec()));
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facture.setFodec(Float.parseFloat(textFodec.getText()));
				facture.setRetour_source(Float.parseFloat(textretourSource.getText()));
				facture.setTaxe_fiscale(Float.parseFloat(textTaxeFiscale.getText()));
				db_Facture.ModifierFacture(facture);
				dispose();
				
			}
		});
		btnModifier.setBounds(259, 240, 89, 38);
		contentPane.add(btnModifier);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(358, 240, 89, 38);
		contentPane.add(btnNewButton);
	}

}
