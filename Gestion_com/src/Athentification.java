
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Athentification extends JFrame {

	private JPanel contentPane;
	private JTextField jlogin;
	private JPasswordField jpwd;
	ConnectionDataBase cdb=null;
	public static int id_caissier ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Athentification frame = new Athentification();
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
	public Athentification() {
		setResizable(false);
		setTitle("Nabeul Soft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 310);
		Image icone = new ImageIcon(this.getClass().getResource("/icone.jpg")).getImage();
		this.setIconImage(icone);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login = new JLabel("Utilisateur");
		login.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		login.setBounds(149, 74, 120, 30);
		contentPane.add(login);
		
		JLabel pwd = new JLabel("Mot de passe");
		pwd.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		pwd.setBounds(149, 115, 120, 30);
		contentPane.add(pwd);
		
		jlogin = new JTextField();
		jlogin.setBounds(274, 74, 150, 30);
		contentPane.add(jlogin);
		jlogin.setColumns(10);
		
		jpwd = new JPasswordField();
		jpwd.setBounds(274, 117, 150, 30);
		contentPane.add(jpwd);
		Image img=new ImageIcon(this.getClass().getResource("/cle.png")).getImage();
		
		JButton connexion = new JButton("Connexion");
		
		connexion.setFont(new Font("Tahoma", Font.BOLD, 13));
		connexion.setForeground(new Color(47, 79, 79));
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reqconnexion="SELECT * FROM `caissier` WHERE `login`='"+jlogin.getText()+"' and `pwd`='"+jpwd.getText()+"'";
				ResultSet rs=ConnectionDataBase.executeQuery(reqconnexion);
				
				try {if(rs.next())
					{                    id_caissier=rs.getInt("id_caissier");
					jlogin.setText(""); jpwd.setText("");
					new OuvertureCaisse(rs.getInt("id_caissier")).setVisible(true);
					setVisible(false);

							
						
						}
				else	
					
				{
					
					JOptionPane.showMessageDialog(null,"Nom utilisateur ou mot de passe incorrect","Erreur",JOptionPane.ERROR_MESSAGE);
					jpwd.setText("");
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		connexion.setBounds(175, 211, 111, 30);
		contentPane.add(connexion);
		
		JButton NewCompte = new JButton("Cr\u00E9er Compte");
		NewCompte.setFont(new Font("Tahoma", Font.BOLD, 13));
		NewCompte.setForeground(new Color(47, 79, 79));
		NewCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==NewCompte)
				{
					AjoutCaissier a=new AjoutCaissier();
					a.setVisible(true);
				}
			}
		});
		NewCompte.setBounds(296, 211, 128, 30);
		contentPane.add(NewCompte);
		
		JLabel image = new JLabel("");
		Image cle=new ImageIcon(this.getClass().getResource("/cle.png")).getImage();
		image.setIcon(new ImageIcon(cle));
		image.setBounds(0, 57, 139, 112);
		contentPane.add(image);
		 cdb=new ConnectionDataBase();
		  chargerConnexion();
		this.addWindowListener(new WindowAdapter() {
			 public void windowClosing( WindowEvent e)
			 {
				 ConnectionDataBase.deconnection();
			 }
			 public void windowClosed( WindowEvent e)
			 {
				 ConnectionDataBase.deconnection();
			 } 
			 
		}); 
		
	}
	public void chargerConnexion()
	{
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
	}
}
