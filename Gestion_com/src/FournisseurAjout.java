import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;
import ControlerPack.FournisseurBase;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;

import classPack.Fournisseur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FournisseurAjout extends JFrame {

	private JPanel contentPane;
	
	private JTextField tref;
	private JTextField traison;
	private JTextField tmatricule;
	private JTextField treg;
	private JTextField tadresse;
	private JTextField tville;
	private JPanel ptel;
	private JTextField ttel;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FournisseurAjout frame = new FournisseurAjout();
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
	public FournisseurAjout(FournisseurBase f) {
		setTitle("Ajout d'un Fournisseur");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 599, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ajout d'un Fournisseur", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(139, 69, 19)));
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(10, 11, 573, 227);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 2, 20, 20));
		
		JPanel pref = new JPanel();
		pref.setBackground(new Color(222, 184, 135));
		panel.add(pref);
		pref.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lraison = new JLabel("Raison Sociale");
		pref.add(lraison);
		
		traison = new JTextField();
		pref.add(traison);
		traison.setColumns(10);
		
		JPanel praison = new JPanel();
		praison.setBackground(new Color(222, 184, 135));
		panel.add(praison);
		praison.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lref = new JLabel("R\u00E9f\u00E9rence");
		praison.add(lref);
		
		tref = new JTextField();
		praison.add(tref);
		tref.setColumns(10);
		
		JPanel pmatricule = new JPanel();
		pmatricule.setBackground(new Color(222, 184, 135));
		panel.add(pmatricule);
		pmatricule.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lmatricule = new JLabel("Matricule Fiscale");
		pmatricule.add(lmatricule);
		
		tmatricule = new JTextField();
		pmatricule.add(tmatricule);
		tmatricule.setColumns(10);
		
		JPanel preg = new JPanel();
		preg.setBackground(new Color(222, 184, 135));
		panel.add(preg);
		preg.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lreg = new JLabel("N\u00B0 R\u00E8glement Commercial");
		preg.add(lreg);
		
		treg = new JTextField();
		preg.add(treg);
		treg.setColumns(10);
		
		JPanel padresse = new JPanel();
		padresse.setBackground(new Color(222, 184, 135));
		panel.add(padresse);
		padresse.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel ladresse = new JLabel("Adresse");
		padresse.add(ladresse);
		
		tadresse = new JTextField();
		padresse.add(tadresse);
		tadresse.setColumns(10);
		
		JPanel pville = new JPanel();
		pville.setBackground(new Color(222, 184, 135));
		panel.add(pville);
		pville.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel lville = new JLabel("Ville");
		pville.add(lville);
		
		tville = new JTextField();
		pville.add(tville);
		tville.setColumns(10);
		
		ptel = new JPanel();
		ptel.setBackground(new Color(222, 184, 135));
		panel.add(ptel);
		ptel.setLayout(new GridLayout(1, 2, 20, 20));
		
		JLabel ltel = new JLabel("N\u00B0 T\u00E9l\u00E9phone");
		ptel.add(ltel);
		
		ttel = new JTextField();
		ptel.add(ttel);
		ttel.setColumns(10);
		
		JButton bannuler = new JButton("Annuler");
		bannuler.setBackground(new Color(222, 184, 135));
		bannuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		bannuler.setBounds(194, 254, 89, 23);
		contentPane.add(bannuler);
		
		JButton bajouter = new JButton("Ajouter");
		bajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fournisseur fr =new Fournisseur(0, tref.getText(), traison.getText(), tadresse.getText(), tville.getText(), tmatricule.getText(), treg.getText(), ttel.getText());
				f.AjoutFournisseur(fr);
				tref.setText(""); traison.setText("");tadresse.setText(""); tville.setText(""); tmatricule.setText(""); treg.setText("");ttel.setText("");
			}
		});
		bajouter.setBackground(new Color(222, 184, 135));
		bajouter.setBounds(303, 254, 89, 23);
		contentPane.add(bajouter);
		
	}
	protected void isMatriculeExist() {
		String matricule=tmatricule.getText();
		
			String req="select count(*) from `fournisseur` where `matricule_fiscale`='"+matricule+"'";
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
				JOptionPane.showMessageDialog(this, "Matricule existe déjà","Erreur",JOptionPane.ERROR_MESSAGE);
	         }
	
	protected void isNumReglementExist() {
		String reg=treg.getText();
		
			String req="select count(*) from `fournisseur` where `num_reg_commercial`='"+reg+"'";
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
				JOptionPane.showMessageDialog(this, "N° Règlement commercial existe déjà","Erreur",JOptionPane.ERROR_MESSAGE);
	         }
	
}
