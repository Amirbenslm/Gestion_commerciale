
import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ClotureBase;
import ControlerPack.ConnectionDataBase;
import classPack.Cloture;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OuvertureCaisse extends JFrame {

	private JPanel contentPane;
	private JTextField textMontant;
	protected ClotureBase db_cloture;
	protected ResultSet rs;
boolean clotureexsiste=false;
public static Cloture clotureCourant;
public static double caisse;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param id_caisiser 
	 */
	public OuvertureCaisse(int id_caisiser) {
		setResizable(false);
		
		setTitle("Ouverture Caisse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 139, 139));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblIdCaissier = new JLabel("ID Caissier :");
		lblIdCaissier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdCaissier.setBounds(10, 81, 105, 30);
		contentPane.add(lblIdCaissier);
		
		JLabel lblMontantOuverture = new JLabel("Montant Ouverture :");
		lblMontantOuverture.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontantOuverture.setBounds(10, 142, 144, 38);
		contentPane.add(lblMontantOuverture);
		
		textMontant = new JTextField();
		textMontant.setBounds(157, 147, 144, 30);
		contentPane.add(textMontant);
		textMontant.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(78, 28, 53, 29);
		contentPane.add(lblDate);
		
		JLabel label = new JLabel("");
		label.setBounds(157, 28, 144, 29);
		contentPane.add(label);
		JLabel label_ID = new JLabel(String.valueOf(id_caisiser));
		label_ID.setBounds(157, 82, 144, 30);
		
		contentPane.add(label_ID);
		
		JLabel lblCaisse = new JLabel("caisse");
		lblCaisse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCaisse.setBounds(11, 111, 105, 30);
		contentPane.add(lblCaisse);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(157, 111, 144, 26);
		contentPane.add(label_1);
		Date actuelle = new Date();
		
		 DateFormat dateformatexist=new SimpleDateFormat("yyyy-MM-dd");
		 String dateexist=dateformatexist.format(actuelle);
		 rs=ConnectionDataBase.executeQuery("select * from cloture where date like '"+dateexist+"%'");
		 try {
			if(rs.next()&& rs.getString("etat").equals("O"))
			 {label.setText(rs.getString(2));
				label_1.setText(String.valueOf(rs.getFloat(3)));
				clotureexsiste=true;
				textMontant.setEditable(false);
				
				caisse=rs.getFloat(3);
			 }
		 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clotureexsiste)
				{
					new Gestion().frame.setVisible(true);
				}
					 else
					 { DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 String dat = dateFormat.format(actuelle);
						 label.setText(dat);
						 caisse=Double.parseDouble(textMontant.getText());
						  clotureCourant=new Cloture(0, dat,Float.parseFloat(textMontant.getText()),0,"O",id_caisiser);
						db_cloture=new ClotureBase();
						clotureCourant=db_cloture.AjoutCloture(clotureCourant);
						new Gestion().frame.setVisible(true);	
					 }
				
			
			}
		});
		btnSuivant.setBounds(230, 220, 89, 30);
		contentPane.add(btnSuivant);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFermer.setBounds(335, 220, 89, 30);
		contentPane.add(btnFermer);
		
		
	}
}
