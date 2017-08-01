import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;



import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Rechercher extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	protected int id;
	protected String req;
	protected ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechercher frame = new Rechercher();
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
	public Rechercher() {
		setTitle("Rechercher");
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 100, 397, 355);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(51, 153, 255), 1, true));
		panel.setBounds(10, 11, 361, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Client", "Fournisseur", "Article"}));
		comboBox.setBounds(10, 11, 130, 32);
		panel.add(comboBox);

		
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBorder(new LineBorder(new Color(51, 153, 255), 1, true));
		textArea.setLineWrap(true);
		textArea.setForeground(SystemColor.textHighlight);
		textArea.setBounds(10, 81, 361, 224);
		textArea.setEditable(false);
		textArea.setOpaque(false);
		
		textField = new JTextField();
		textField.setBounds(192, 11, 159, 32);
		panel.add(textField);
		textField.setColumns(10);
		//textField.setInputVerifier(new FloatVerifier());
		
		JLabel lblId = new JLabel(" ID :");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(150, 11, 35, 32);
		panel.add(lblId);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=Integer.parseInt(textField.getText());
				if(comboBox.getSelectedItem().equals("Client"))
				{req="select * from client where id_client="+id;
				rs=ConnectionDataBase.executeQuery(req);
				try {
					if(rs.next())
					{
					textArea.setText(" ID : "+rs.getInt(1)+"\n Cin :  "+rs.getString(2)+"\n nom :"+rs.getString(3)+" \n prénom :  "+rs.getString(4)+"\n Date :  "+rs.getString(5)+"\n adresse :  "+rs.getString(6)+"\n ville :  "+rs.getString(7)+"\n Telephone :  "+rs.getString(8)+"\n email :  "+rs.getString(9)+"\n Matricule fiscale :  "+rs.getString(10)+"\n N° Registration commerciale :  "+rs.getString(11));	
					}
					else
					{JOptionPane.showMessageDialog(null,"N'existe pas ce client!","Erreur",JOptionPane.ERROR_MESSAGE);}
				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(comboBox.getSelectedItem().equals("Fournisseur"))
				{req="select * from fournisseur where id_fournisseur="+id;
				rs=ConnectionDataBase.executeQuery(req);
				try {
					if(rs.next())
					{
					textArea.setText(" ID : "+rs.getInt(1)+"\n Réference :  "+rs.getString(2)+"\n Raison Sociale :"+rs.getString(3)+"\n adresse :  "+rs.getString(4)+"\n ville :  "+rs.getString(5)+"\n Telephone :  "+rs.getString(8)+"\n Matricule fiscale :  "+rs.getString(6)+"\n N° Registration commerciale :  "+rs.getString(7));	
					}
					else
					{JOptionPane.showMessageDialog(null,"N'existe pas ce fournisseur!","Erreur",JOptionPane.ERROR_MESSAGE);}
				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(comboBox.getSelectedItem().equals("Article"))
				{req="select * from article where id_article="+id;
				rs=ConnectionDataBase.executeQuery(req);
				try {
					if(rs.next())
					{
					textArea.setText(" ID : "+rs.getInt(1)+"\n Réference :  "+rs.getString(2)+"\n Désignation :"+rs.getString(3)+" \n Prix Unitaire :  "+rs.getDouble(4)+"\n Prix Vente :  "+rs.getDouble(5)+"\n Quantité en Stock :  "+rs.getFloat(6)+"\n Quantité Minimum :  "+rs.getFloat(7)+"\n Code a barre :  "+rs.getString(8)+"\n ID Famille :  "+rs.getInt(9)+"\n ID Taxe  :  "+rs.getInt(10));	
					}
					else
					{JOptionPane.showMessageDialog(null,"Article N'existe pas  !","Erreur",JOptionPane.ERROR_MESSAGE);}
				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			
			}
		});
		
		contentPane.add(textArea);
	}
}
