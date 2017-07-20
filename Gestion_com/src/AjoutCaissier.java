import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JButton;

import classPack.Caissier;
import ControlerPack.CaissierBase;
import ControlerPack.ConnectionDataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjoutCaissier extends JFrame implements FocusListener,ActionListener {

	private JPanel contentPane;
	private JTextField jnom;
	private JTextField jprenom;
	private JTextField jncin;
	private JTextField jadresse;
	private JTextField jville;
	private JTextField jtel;
	private JTextField juser;
	private JTextField jpwd;
	private JButton creer;
	public CaissierBase cb=null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutCaissier frame = new AjoutCaissier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AjoutCaissier() {
		setResizable(false);
		setBackground(new Color(0, 139, 139));
		setTitle("Ajout d'un caissier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 120, 450, 508);
		
		
		cb=new CaissierBase();
		Image icone = new ImageIcon(this.getClass().getResource("/icone.jpg")).getImage();
		this.setIconImage(icone);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setForeground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Formulaire", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setBounds(27, 11, 379, 280);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 2, 20, 20));
		
		JLabel nom = new JLabel("Nom");
		nom.setForeground(new Color(230, 230, 250));
		nom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(nom);
		
		jnom = new JTextField();
	
		jnom.setText("Saisir votre nom");
		panel.add(jnom);
		jnom.setColumns(10);
		jnom.addFocusListener(this);
		
		JLabel prenom = new JLabel("Prenom");
		prenom.setForeground(new Color(230, 230, 250));
		prenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(prenom);
		
		jprenom = new JTextField();jprenom.addFocusListener(this);
		jprenom.setText("Saisir votre prenom");
		panel.add(jprenom);
		jprenom.setColumns(10);
		
		JLabel ncin = new JLabel("NCin");
		ncin.setForeground(new Color(230, 230, 250));
		ncin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(ncin);
		
		jncin = new JTextField();jncin.addFocusListener(this);
		jncin.setText("Saisir votre num\u00E9ro de Cin");
		panel.add(jncin);
		jncin.setColumns(10);
		jncin.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				if(jncin.getText().length()==8)
					jadresse.requestFocus();
				}
				public void keyTyped(KeyEvent arg0) {
					if(jncin.getText().length()==8)
						jadresse.requestFocus();
					
				}
				public void keyPressed(KeyEvent arg0) {
					if(jncin.getText().length()==8)
						jadresse.requestFocus();
				}
		});
		jncin.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				isCINExist();
				//jncin.setText("Saisir votre numéro de Cin");
			}
		});
		
		JLabel adresse = new JLabel("Adresse");
		adresse.setForeground(new Color(230, 230, 250));
		adresse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(adresse);
		
		jadresse = new JTextField();jadresse.addFocusListener(this);
		jadresse.setText("Saisir votre adresse");
		panel.add(jadresse);
		jadresse.setColumns(10);
		
		JLabel ville = new JLabel("Ville");
		ville.setForeground(new Color(230, 230, 250));
		ville.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(ville);
		
		jville = new JTextField();jville.addFocusListener(this);
		jville.setText("Saisir votre ville");
		panel.add(jville);
		jville.setColumns(10);
		
		JLabel tel = new JLabel("T\u00E9l\u00E9phone");
		tel.setForeground(new Color(230, 230, 250));
		tel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(tel);
		
		jtel = new JTextField();jtel.addFocusListener(this);
		jtel.setText("Saisir votre t\u00E9l\u00E9phone");
		panel.add(jtel);
		jtel.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Choisir un nom d'utilisateur et un mot de passe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel_1.setBounds(27, 302, 379, 105);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 20, 20));
		
		JLabel login = new JLabel("Nom utilisateur");
		login.setForeground(new Color(230, 230, 250));
		login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel_1.add(login);
		
		juser = new JTextField();juser.addFocusListener(this);
		juser.setText("Saisir un nom d'utilisateur");
		panel_1.add(juser);
		juser.setColumns(10);
		
		JLabel pwd = new JLabel("Mot de passe");
		pwd.setForeground(new Color(230, 230, 250));
		pwd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel_1.add(pwd);
		
		jpwd = new JTextField();jpwd.addFocusListener(this);
		jpwd.setForeground(new Color(0, 0, 0));
		jpwd.setText("Saisir un mot de passe");
		panel_1.add(jpwd);
		jpwd.setColumns(10);
		
		 creer = new JButton("Cr\u00E9er");creer.addActionListener(this);
		creer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		creer.setBounds(317, 435, 89, 23);
		contentPane.add(creer);
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==annuler)
				{ 
					
					 jnom.setText("Saisir votre nom");
					
					jprenom.setText("Saisir votre prenom");
					jncin.setText("Saisir votre numéro de Cin");
					jadresse.setText("Saisir votre adresse");
					jtel.setText("Saisir votre téléphone");
					jville.setText("Saisir votre ville");
					juser.setText("Saisir un nom d'utilisateur");
					jpwd.setText("Saisir un mot de passe");
					
				}
			}
		});
		annuler.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		annuler.setBounds(199, 435, 89, 23);
		contentPane.add(annuler);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jnom)
		{if(jnom.getText().equals("Saisir votre nom"))
			jnom.setText("");
		}
		if(e.getSource()==jprenom)
		{
			if(jprenom.getText().equals("Saisir votre prenom"))
				jprenom.setText("");
		}
		if(e.getSource()==jncin)
		{
			if(jncin.getText().equals("Saisir votre numéro de Cin"))
				jncin.setText("");
		}
		if(e.getSource()==jadresse)
		{
			if(jadresse.getText().equals("Saisir votre adresse"))
				jadresse.setText("");
		}
		if(e.getSource()==jville)
		{
			if(jville.getText().equals("Saisir votre ville"))
				jville.setText("");
		}
		if(e.getSource()==jtel)
		{
			if(jtel.getText().equals("Saisir votre téléphone"))
				jtel.setText("");
		}
		if(e.getSource()==juser)
		{
			if(juser.getText().equals("Saisir un nom d'utilisateur"))
				juser.setText("");
		}
		if(e.getSource()==jpwd)
		{
			if(jpwd.getText().equals("Saisir un mot de passe"))
				jpwd.setText("");
		}
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jnom)
		{ if(jnom.getText().length()==0)
			jnom.setText("Saisir votre nom");
		}
		if(e.getSource()==jprenom)
		{ if(jprenom.getText().length()==0)
			jprenom.setText("Saisir votre prenom");
		}
		if(e.getSource()==jncin)
		{ if(jncin.getText().length()==0)
			jncin.setText("Saisir votre numéro de Cin");
		}
		if(e.getSource()==jadresse)
		{ if(jadresse.getText().length()==0)
			jadresse.setText("Saisir votre adresse");
		}
		if(e.getSource()==jville)
		{ if(jville.getText().length()==0)
			jville.setText("Saisir votre ville");
		}
		if(e.getSource()==jtel)
		{ if(jtel.getText().length()==0)
			jtel.setText("Saisir votre téléphone");
		}
		if(e.getSource()==juser)
		{ if(juser.getText().length()==0)
			juser.setText("Saisir un nom d'utilisateur");
		}
		if(e.getSource()==jpwd)
		{ if(jpwd.getText().length()==0)
			jpwd.setText("Saisir un mot de passe");
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==creer)
		{
			
			ajouterCaissier();
			
			
			}
		}
	
	private boolean isValidNumCin(String numInscription) {		
		return (numInscription.length()==8)&&numInscription.matches("\\d\\d\\d\\d\\d\\d\\d\\d");
	}
	protected void isCINExist() {
		String cin=jncin.getText();
		if(isValidNumCin(cin))
		{
			String req="select count(*) from caissier where ncin='"+cin+"'";
			System.out.println(req);
			ResultSet rs=ConnectionDataBase.executeQuery(req);
			int count=-1;
			try {
				if(rs.next())
					count=rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(count==1)
				JOptionPane.showMessageDialog(this, "CIN existe","Erreur",JOptionPane.ERROR_MESSAGE);
			//jncin.setText("Saisir votre numéro de Cin");	
		}
	}
	protected void ajouterCaissier() {
		String errorMessage="";
		
		String nom=jnom.getText();
		if(nom.equals("")||(nom.equals("Saisir votre nom")))
			errorMessage+="Vous devez saisir un nom.\n";
		String prenom=jprenom.getText();
		if(prenom.equals("")||prenom.equals("Saisir votre prenom"))
			errorMessage+="Vous devez saisir un prenom.\n";
        String ncin=jncin.getText();
        if(ncin.equals("")||ncin.equals("Saisir votre numéro de Cin"))
			errorMessage+="Vous devez saisir un N°Cin.\n";
		/*if(!isValidNumCin(ncin))
		{
			errorMessage+="CIN invalide.\n";
		}*/
		String adresse=jadresse.getText();
		
		if(adresse.equals("")||adresse.equals("Saisir votre adresse"))
			errorMessage+="Vous devez saisir une adresse.\n";
		String ville=jville.getText();
		if(ville.equals("")||ville.equals("Saisir votre ville"))
			errorMessage+="Vous devez saisir une ville.\n";
		String tel=jtel.getText();
		if(tel.equals("")||tel.equals("Saisir votre téléphone"))
			errorMessage+="Vous devez saisir un numero de téléphone.\n";
		String login=juser.getText();
		if(login.equals("")||login.equals("Saisir un nom d'utilisateur"))
			errorMessage+="Vous devez saisir un nom d'utilisateur.\n";
		String pwd=jpwd.getText();
		if(pwd.equals("")||pwd.equals("Saisir un mot de passe"))
			errorMessage+="Vous devez saisir un mot de passe.\n";
		
		if(errorMessage.equals(""))
		{
			Caissier f1=new Caissier(0, jncin.getText(), jnom.getText(), jprenom.getText(), jadresse.getText(), jville.getText(), jtel.getText(), juser.getText(), jpwd.getText());
			System.out.println(jncin.getText()+""+jnom.getText()+""+jprenom.getText()+""+jadresse.getText()+""+jville.getText()+""+jtel.getText()+", "+juser.getText()+"  "+jpwd.getText());
			cb.AjoutCaissier(f1);
			JOptionPane.showMessageDialog(null, " Ajout avec succée !!!","Ajout Chef",JOptionPane.INFORMATION_MESSAGE);
            
			jnom.setText("Saisir votre nom");jprenom.setText("Saisir votre prénom");jncin.setText("Saisir votre numéro de Cin");
			jadresse.setText("Saisir le nom de la société");jville.setText("Saisir votre email");
			jtel.setText("Saisir votre mot de passe");juser.setText("Saisir votre N° du téléphone");jpwd.setText("");
		}
		else
			JOptionPane.showMessageDialog(this, errorMessage,"Erreur",JOptionPane.ERROR_MESSAGE);
	}


		
	
	
	
}
