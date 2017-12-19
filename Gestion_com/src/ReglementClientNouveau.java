import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import ControlerPack.ConnectionDataBase;
import ControlerPack.Document_venteModel;
import ControlerPack.Reglement_venteBase;
import classPack.Reglement_vente;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ReglementClientNouveau extends JFrame {

	private JPanel contentPane;
	private JTextField textMontant;
	private JDateChooser tdate_echance;
	private DefaultComboBoxModel<String> dcm;
	private JComboBox cb_client;
	protected ResultSet rsrech;
	protected Document_venteModel mytablemodel;
	protected JTable table =new JTable();
	protected JDateChooser tdate;
	Reglement_venteBase db_reglement=new Reglement_venteBase();
	protected Reglement_vente reglement;
	/**
	 * Launch the application.
	 */
	
	public ReglementClientNouveau() {
		setTitle("R\u00E9glement Client");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 689, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 663, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClient.setBounds(10, 11, 77, 32);
		panel.add(lblClient);
		
		JLabel lblModePayement = new JLabel("Mode Paiement");
		lblModePayement.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModePayement.setBounds(317, 11, 116, 32);
		panel.add(lblModePayement);
		 dcm = new DefaultComboBoxModel<String>();
			ResultSet rs=ConnectionDataBase.executeQuery("select * from client");
			dcm.addElement("Choisit un Client");
			try {
				while(rs.next())
				{dcm.addElement(rs.getInt(1)+" "+rs.getString("nom")+"   "+rs.getString("prenom"));
				
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			cb_client = new JComboBox(dcm);
			cb_client.setBounds(97, 11, 181, 32);
			panel.add(cb_client);
			cb_client.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
					if(cb_client.getSelectedItem().equals("Choisit un Client")==false)
					{ StringTokenizer st = new StringTokenizer((String)cb_client.getSelectedItem(),"   ");  
				     String     id_client=st.nextToken();
					rsrech=ConnectionDataBase.executeQuery("select * from document_vente where  id_client= "+Integer.parseInt(id_client) );
					mytablemodel=new Document_venteModel(rsrech);
					table.setModel(mytablemodel);
				}}
			});
		
	

		JComboBox cb_ModePaiement = new JComboBox();
		cb_ModePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb_ModePaiement.getSelectedItem().equals("Espece"))
				{tdate_echance.setEnabled(false);}
				if(cb_ModePaiement.getSelectedItem().equals("Par Chéque"))
				{tdate_echance.setEnabled(true);}
			}
		});
		cb_ModePaiement.setModel(new DefaultComboBoxModel(new String[] {"Espece", "Par Chéque"}));
		cb_ModePaiement.setBounds(443, 17, 136, 26);
		panel.add(cb_ModePaiement);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMontant.setBounds(10, 69, 77, 28);
		panel.add(lblMontant);
		
		textMontant = new JTextField();
		textMontant.setBounds(97, 69, 181, 32);
		panel.add(textMontant);
		textMontant.setColumns(10);
		
		JLabel lblEchance = new JLabel("Ech\u00E9ance");
		lblEchance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEchance.setBounds(317, 69, 116, 28);
		panel.add(lblEchance);
		tdate_echance = new JDateChooser();
		tdate_echance.setEnabled(false);
		panel.add(tdate_echance);
		tdate_echance.setBounds(443, 69, 136, 28);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.textHighlight));
		scrollPane.setBounds(10, 135, 663, 242);
		contentPane.add(scrollPane);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textMontant.getText().equals("")&&!cb_client.getSelectedItem().equals("Choisit un Client"))
				{	
					if(table.isRowSelected(table.getSelectedRow()))
				
				{
					
					Date actuelle = new Date();
				 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 String date_reglement = dateFormat.format(actuelle);
				if(cb_ModePaiement.getSelectedItem().equals("Espece"))
				{
		 reglement=new  Reglement_vente(0,Double.parseDouble(textMontant.getText()), date_reglement,cb_ModePaiement.getSelectedItem().toString(),"0001-01-01",(int)mytablemodel.getValueAt(table.getSelectedRow(),0));}
				if(cb_ModePaiement.getSelectedItem().equals("Par Chéque"))
				{ java.util.Date bir=tdate_echance.getDate();
					java.sql.Date echeance = new java.sql.Date(bir.getTime());
				 reglement=new  Reglement_vente(0,Double.parseDouble(textMontant.getText()), date_reglement,cb_ModePaiement.getSelectedItem().toString(), echeance.toString(),(int)mytablemodel.getValueAt(table.getSelectedRow(),0));}
			db_reglement.AjoutReglement_vente(reglement);
		
			JOptionPane.showMessageDialog(null,"Réglement Enregistrer","Succéss",JOptionPane.INFORMATION_MESSAGE);
			
				}
		
			
					else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner un document!","Erreur",JOptionPane.ERROR_MESSAGE);}
				}
			
			else	{JOptionPane.showMessageDialog(null,"Il faut choisir un client et entrer un montant!","Erreur",JOptionPane.ERROR_MESSAGE);}

			}});
		btnEnregistrer.setBounds(401, 412, 111, 34);
		contentPane.add(btnEnregistrer);
		btnEnregistrer.setBackground(SystemColor.controlHighlight);
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setBounds(541, 412, 111, 34);
		btnAnnuler.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAnnuler);
	}
}
