import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class Athentification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField pwd;

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
		setTitle("Athentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		lblLogin.setBounds(162, 77, 67, 24);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		lblPassword.setBounds(162, 115, 67, 30);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(251, 74, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(251, 115, 150, 30);
		contentPane.add(pwd);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img=new ImageIcon(this.getClass().getResource("/cle.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		lblNewLabel.setBounds(10, 36, 134, 130);
		contentPane.add(lblNewLabel);
		
		JButton connexion = new JButton("Connexion");
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
				ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
				ResultSet rs=ConnectionDataBase.executeQuery("select * from caissier where login='"+textField.getText()+"'");
				String pwdbase,passwd;
				try {if(rs.next())
					{
					pwdbase = rs.getString(9);
					passwd=new String(pwd.getPassword());
					System.out.println(passwd);
						if(pwdbase.equals(passwd))
						{
							System.out.println("Success connection");
						}
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		connexion.setBounds(175, 211, 98, 30);
		contentPane.add(connexion);
		
		JButton NewCompte = new JButton("New compte");
		NewCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		NewCompte.setBounds(296, 211, 105, 30);
		contentPane.add(NewCompte);
	}
}
