import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import ControlerPack.ClientBase;
import classPack.Client;


public class ClientModifier extends JFrame {

	private JPanel contentPane;
	private JTextField tnom,tprenom,ttel,tcin,tmatricule,treg,temail,tadresse,tville;
	private JDateChooser tdate;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientModifier frame = new ClientModifier();
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
	public ClientModifier(ClientBase db_client,Client cl) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Modification d'un client");
		setResizable(false);
		setBounds(100, 100, 629, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modification d'un client", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(240, 128, 128)));
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
		tprenom.setText(cl.getPrenom());
		tnom.setText(cl.getNom());
		tcin.setText(cl.getCin());
		String datestr=cl.getDateclient();
		SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dateObj;
		try {	
			dateObj = curFormater.parse(datestr);
			Calendar calendar = Calendar.getInstance();
			calendar .setTime(dateObj);
			tdate.setCalendar(calendar);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	

		

		
		//tdate.setText(cl.getDateclient());
		ttel.setText(cl.getTel());
		temail.setText(cl.getEmail());
		tmatricule.setText(cl.getMatricule_fiscale());
		treg.setText(cl.getNum_reg_commerciale());
		tadresse.setText(cl.getAdresse());
		tville.setText(cl.getVille());
		
		JButton bannuler = new JButton("Annuler");
		bannuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bannuler.setBackground(new Color(210, 180, 140));
		bannuler.setBounds(211, 288, 89, 23);
		contentPane.add(bannuler);
		
		JButton bmodifier = new JButton("Modifier");
		bmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					cl.setNom(tnom.getText());cl.setCin(tcin.getText());
					cl.setPrenom(tprenom.getText());
					
					java.util.Date bir=tdate.getDate();
					java.sql.Date d = new java.sql.Date(bir.getTime());
					cl.setDateclient(d.toString());
					cl.setAdresse(tadresse.getText());cl.setVille(tville.getText());
					cl.setTel(ttel.getText());cl.setMatricule_fiscale(tmatricule.getText());
					cl.setNum_reg_commerciale(treg.getText());cl.setEmail(temail.getText());
				db_client.modifierClient(cl);
				tnom.setText("");tprenom.setText("");tcin.setText("");
				
				ttel.setText("");treg.setText("");
				tmatricule.setText("");tadresse.setText("");tville.setText("");temail.setText("");
			}
		});
		bmodifier.setBackground(new Color(210, 180, 140));
		bmodifier.setBounds(310, 288, 89, 23);
		contentPane.add(bmodifier);
	}
	
	}


