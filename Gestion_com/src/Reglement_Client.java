

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;
import ControlerPack.Reglement_venteBase;
import ControlerPack.Reglement_venteModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Reglement_Client extends JFrame {

	private JPanel contentPane;
	private Reglement_venteBase db_reglementvente=new Reglement_venteBase();
	private JTable table;
	private JComboBox<String> cb_client;
	private DefaultComboBoxModel<String> dcm;
	protected ResultSet rsrech;
	
	protected String reqfiltre;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Reglement_Client() {
		setResizable(false);
		setTitle("Réglements des Clients");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 827, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table =new JTable();
		table.setModel(db_reglementvente.mytablemodel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.textHighlight));
		scrollPane.setBounds(10, 195, 791, 343);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 791, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(SystemColor.controlHighlight);
	/*	btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Document_vente a1= db_documentvente.getDocument((int)table.getValueAt(table.getSelectedRow(),0));
			
			}else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}

			 
		});*/
		btnModifier.setBounds(0, 11, 112, 57);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(SystemColor.controlHighlight);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.isRowSelected(table.getSelectedRow()))
				{
					 int i=JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                             "Veuillez confirmer votre choix",
                             JOptionPane.YES_NO_OPTION);
					 	if(i==0){
					db_reglementvente.supprimerReglement_vente(((int)table.getValueAt(table.getSelectedRow(),0)));
					 			}
			}
			else
			{JOptionPane.showMessageDialog(null,"Il faut sélectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
			
		});
		btnSupprimer.setBounds(110, 11, 112, 57);
		panel.add(btnSupprimer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_1.setBounds(10, 96, 791, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
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
			 
			cb_client = new JComboBox<String>(dcm);
			cb_client.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
					if(cb_client.getSelectedItem().equals("Choisit un Client")==false)
					{ StringTokenizer st = new StringTokenizer((String)cb_client.getSelectedItem(),"   ");  
				     String     id_client=st.nextToken();
					rsrech=ConnectionDataBase.executeQuery("select id_reg_vente,montant,date_reglement,mode_paiement,echeance,id_doc_vente from document_vente d,reglement_vente r where  id_client= "+Integer.parseInt(id_client)+" and d.id_documentV = r.id_doc_vente" );
					db_reglementvente.mytablemodel=new Reglement_venteModel(rsrech);
					table.setModel(db_reglementvente.mytablemodel);
				}}
			});
		
		cb_client.setBounds(78, 24, 210, 35);
		panel_1.add(cb_client);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClient.setBounds(10, 24, 81, 35);
		panel_1.add(lblClient);
		
		JRadioButton rdbtnFacture = new JRadioButton("Facture");
		rdbtnFacture.setBounds(313, 21, 109, 23);
		panel_1.add(rdbtnFacture);
		
		JRadioButton rdbtnBonLivraison = new JRadioButton("Bon Livraison");
		rdbtnBonLivraison.setBounds(313, 47, 109, 23);
		panel_1.add(rdbtnBonLivraison);
		
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.setBackground(SystemColor.controlHighlight);
		
		btnFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFacture.isSelected()||rdbtnBonLivraison.isSelected())
				{
				if(rdbtnFacture.isSelected())
				{
					reqfiltre="select id_reg_vente,montant,date_reglement,mode_paiement,echeance,id_doc_vente from document_vente d,reglement_vente r where d.type_doc='F' and d.id_documentV = r.id_doc_vente";}
				if(rdbtnBonLivraison.isSelected())
				{
					reqfiltre="select id_reg_vente,montant,date_reglement,mode_paiement,echeance,id_doc_vente from document_vente d,reglement_vente r where d.type_doc='BL' and d.id_documentV = r.id_doc_vente";}
				
				
				if(cb_client.getSelectedItem().equals("Choisit un Client"))
				{db_reglementvente.mytablemodel=new Reglement_venteModel(ConnectionDataBase.executeQuery(reqfiltre));}
				
				if(cb_client.getSelectedItem().equals("Choisit un Client")==false)
				{
					 StringTokenizer st = new StringTokenizer((String)cb_client.getSelectedItem(),"   ");  
				     String     id_client=st.nextToken();
				     db_reglementvente.mytablemodel=new Reglement_venteModel(ConnectionDataBase.executeQuery(reqfiltre+" and  id_client= "+Integer.parseInt(id_client)));}
				
				
				
				
				
				table.setModel(db_reglementvente.mytablemodel);
			
			}
			else {JOptionPane.showMessageDialog(null,"Il faut cocher un type de document!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}
		});
		btnFiltrer.setBounds(428, 7, 153, 29);
		panel_1.add(btnFiltrer);
		
		JButton btnToutLesReglement = new JButton("Tout les Réglements");
		btnToutLesReglement.setAutoscrolls(true);
		btnToutLesReglement.setBounds(428, 44, 153, 29);
		panel_1.add(btnToutLesReglement);
		btnToutLesReglement.setBackground(SystemColor.controlHighlight);
		ButtonGroup btngroup=new ButtonGroup();
		btngroup.add(rdbtnFacture);
		btngroup.add(rdbtnBonLivraison);
		btnToutLesReglement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btngroup.clearSelection();
				db_reglementvente.mytablemodel=new Reglement_venteModel(ConnectionDataBase.executeQuery("select * from reglement_vente"));
				table.setModel(db_reglementvente.mytablemodel);
				
			}
		});
		
		
	}
}
