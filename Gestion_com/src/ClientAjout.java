import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import classPack.Client;
import ControlerPack.ClientBase;
import ControlerPack.ConnectionDataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientAjout extends JFrame {

	private JPanel contentPane;
	private JTextField tprenom;
	private JTextField tnom;
	private JTextField tcin;
	private JTextField tadresse;
	private JTextField ttel;
	private JTextField tville;
	private JTextField treg;
	private JTextField tmatricule;
	//private JTextField tdate;
	private JTextField temail;
	private JDateChooser tdate;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ClientAjout(ClientBase db_client) {
		setTitle("Ajout d'un Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout d'un client", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(240, 128, 128)));
		panel.setBounds(10, 11, 593, 266);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		
		JPanel pprenom = new JPanel();
		pprenom.setBackground(new Color(240, 230, 140));
		panel.add(pprenom);
		pprenom.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lnom = new JLabel("Nom");
		pprenom.add(lnom);
		
		tnom = new JTextField();
		pprenom.add(tnom);
		tnom.setColumns(10);
		
		JPanel pnom = new JPanel();
		pnom.setBorder(null);
		pnom.setBackground(new Color(240, 230, 140));
		panel.add(pnom);
		pnom.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lprenom = new JLabel("Pr\u00E9nom");
		pnom.add(lprenom);
		
		tprenom = new JTextField();
		pnom.add(tprenom);
		tprenom.setColumns(10);
		
		JPanel padresse = new JPanel();
		padresse.setBackground(new Color(240, 230, 140));
		panel.add(padresse);
		padresse.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel ldate = new JLabel("Date naissance");
		padresse.add(ldate);
		
		tdate = new JDateChooser();
		padresse.add(tdate);
		//tdate.setColumns(10);
		
		JPanel pemail = new JPanel();
		pemail.setBackground(new Color(240, 230, 140));
		panel.add(pemail);
		pemail.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lcin = new JLabel("N\u00B0Cin");
		pemail.add(lcin);
		
		tcin = new JTextField();
		pemail.add(tcin);
		tcin.setColumns(10);
		tcin.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				if(tcin.getText().length()==8)
					ttel.requestFocus();
				}
				public void keyTyped(KeyEvent arg0) {
					if(tcin.getText().length()==8)
						ttel.requestFocus();
					
				}
				public void keyPressed(KeyEvent arg0) {
					if(tcin.getText().length()==8)
						ttel.requestFocus();
				}
		});
		tcin.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				isCINExist();
				//jncin.setText("Saisir votre numéro de Cin");
			}
		});
		
		JPanel ptel = new JPanel();
		ptel.setBackground(new Color(240, 230, 140));
		panel.add(ptel);
		ptel.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel ltel = new JLabel("N\u00B0T\u00E9l\u00E9phone");
		ptel.add(ltel);
		
		ttel = new JTextField();
		ptel.add(ttel);
		ttel.setColumns(10);
		
		JPanel pdate = new JPanel();
		pdate.setBackground(new Color(240, 230, 140));
		panel.add(pdate);
		pdate.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel ladresse = new JLabel("Adresse");
		pdate.add(ladresse);
		
		tadresse = new JTextField();
		pdate.add(tadresse);
		tadresse.setColumns(10);
		
		JPanel pville = new JPanel();
		pville.setBackground(new Color(240, 230, 140));
		panel.add(pville);
		pville.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lvile = new JLabel("Ville");
		pville.add(lvile);
		
		tville = new JTextField();
		pville.add(tville);
		tville.setColumns(10);
		
		JPanel pmatricule = new JPanel();
		pmatricule.setBackground(new Color(240, 230, 140));
		panel.add(pmatricule);
		pmatricule.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lemail = new JLabel("E-mail");
		pmatricule.add(lemail);
		
		temail = new JTextField();
		pmatricule.add(temail);
		temail.setColumns(10);
		
		temail.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				if(Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", temail.getText()))
				{ //System.out.println(temail.getText());
					treg.requestFocus();
				}
				else
				{JOptionPane.showMessageDialog(null, "Votre e-mail n'a pas la format qqc@qqc.qqc","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JPanel preg = new JPanel();
		preg.setBackground(new Color(240, 230, 140));
		panel.add(preg);
		preg.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lreg = new JLabel("N\u00B0 r\u00E8glement Fiscale ");
		preg.add(lreg);
		
		treg = new JTextField();
		preg.add(treg);
		treg.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lmatricule = new JLabel("N\u00B0 Matricule Fiscale ");
		panel_1.add(lmatricule);
		
		tmatricule = new JTextField();
		panel_1.add(tmatricule);
		tmatricule.setColumns(10);
		
		JButton bannuler = new JButton("Annuler");
		bannuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bannuler.setBackground(new Color(210, 180, 140));
		bannuler.setBounds(211, 288, 89, 23);
		contentPane.add(bannuler);
		
		JButton bajouter = new JButton("Ajouter");
		bajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*boolean  essai = Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", "qqc.qqc@qqc.qqc");
                System.out.println(essai);*/
				java.util.Date bir=tdate.getDate();
				java.sql.Date d = new java.sql.Date(bir.getTime());
               Client cl=new Client(0, tnom.getText(), tprenom.getText(), tcin.getText(), d.toString(), tadresse.getText(), tville.getText(), tmatricule.getText(), treg.getText(), ttel.getText(), temail.getText()); 
				db_client.ajouterClient(cl);
				tnom.setText("");tprenom.setText("");tcin.setText("");
				//tdate.setText("");
				ttel.setText("");treg.setText("");
				tmatricule.setText("");tadresse.setText("");tville.setText("");temail.setText("");
			
			}
		});
		bajouter.setBackground(new Color(210, 180, 140));
		bajouter.setBounds(310, 288, 89, 23);
		contentPane.add(bajouter);
	}
	protected void isCINExist() {
		String cin=tcin.getText();
		if(isValidNumCin(cin))
		{
			String req="select count(*) from client where ncin='"+cin+"'";
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
	           // tcin.setText("");
		}
	}
	private boolean isValidNumCin(String numInscription) {		
		return (numInscription.length()==8)&&numInscription.matches("\\d\\d\\d\\d\\d\\d\\d\\d");
	}
	public static boolean isEmailAdress(String email){
	     
		boolean  essai = Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", "qqc.qqc@qqc.qqc");
        return(essai);
		}
}
