import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;
import ControlerPack.Document_venteBase;
import ControlerPack.Document_venteModel;
import classPack.Article;
import classPack.Document_vente;

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

public class Document_VenteFrame extends JFrame {

	private JPanel contentPane;
	private Document_venteBase db_documentvente=new Document_venteBase();
	private JTable table;
	private JComboBox cb_client;
	private DefaultComboBoxModel<String> dcm;
	protected ResultSet rsrech;

	protected String reqfiltre;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Document_VenteFrame() {
		setResizable(false);
		setTitle("Document vente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 100, 827, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table =new JTable();
		table.setModel(db_documentvente.mytablemodel);
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
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Document_vente a1= db_documentvente.getDocument((int)table.getValueAt(table.getSelectedRow(),0));
			
			}else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}

			 
		});
		btnModifier.setBounds(0, 7, 112, 68);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(SystemColor.controlHighlight);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{int i=JOptionPane.showConfirmDialog(null, "La suppression est irr�versible. �tes-vous s�r de vouloir continuer?",
                        "Veuillez confirmer votre choix",
                        JOptionPane.YES_NO_OPTION);
				 	if(i==0){
				 		
					db_documentvente.supprimerDocument_vente((db_documentvente.getDocument((int)table.getValueAt(table.getSelectedRow(),0))).getId_documentV());
					
			}}
			else
			{JOptionPane.showMessageDialog(null,"Il faut s�lectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
			
		});
		btnSupprimer.setBounds(110, 7, 112, 68);
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
			 
			cb_client = new JComboBox(dcm);
			cb_client.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
					if(cb_client.getSelectedItem().equals("Choisit un Client")==false)
					{ StringTokenizer st = new StringTokenizer((String)cb_client.getSelectedItem(),"   ");  
				     String     id_client=st.nextToken();
					rsrech=ConnectionDataBase.executeQuery("select * from document_vente where  id_client= "+Integer.parseInt(id_client) );
					db_documentvente.mytablemodel=new Document_venteModel(rsrech);
					table.setModel(db_documentvente.mytablemodel);
				}}
			});
		
		cb_client.setBounds(78, 24, 210, 35);
		panel_1.add(cb_client);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClient.setBounds(10, 24, 81, 35);
		panel_1.add(lblClient);
		
		JRadioButton rdbtnFacture = new JRadioButton("Facture");
		rdbtnFacture.setBounds(313, 7, 109, 23);
		panel_1.add(rdbtnFacture);
		
		JRadioButton rdbtnBonLivraison = new JRadioButton("Bon Livraison");
		rdbtnBonLivraison.setBounds(313, 30, 109, 23);
		panel_1.add(rdbtnBonLivraison);
		
		JRadioButton rdbtnDevis = new JRadioButton("Devis");
		rdbtnDevis.setBounds(313, 56, 109, 23);
		panel_1.add(rdbtnDevis);
		
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.setBackground(SystemColor.controlHighlight);
		
		btnFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFacture.isSelected()||rdbtnBonLivraison.isSelected()||rdbtnDevis.isSelected())
				{
					if(rdbtnFacture.isSelected())
				{reqfiltre="select * from document_vente where type_doc='F'";}
				if(rdbtnBonLivraison.isSelected())
				{reqfiltre="select * from document_vente where type_doc='BL'";}
				if(rdbtnDevis.isSelected())
				{reqfiltre="select * from document_vente where type_doc='D'";}
				
				if(cb_client.getSelectedItem().equals("Choisit un Client"))
				{db_documentvente.mytablemodel=new Document_venteModel(ConnectionDataBase.executeQuery(reqfiltre));}
				
				if(cb_client.getSelectedItem().equals("Choisit un Client")==false)
				{
					 StringTokenizer st = new StringTokenizer((String)cb_client.getSelectedItem(),"   ");  
				     String     id_client=st.nextToken();
				     db_documentvente.mytablemodel=new Document_venteModel(ConnectionDataBase.executeQuery(reqfiltre+" and  id_client= "+Integer.parseInt(id_client)));}
				
				
				
				
				
				table.setModel(db_documentvente.mytablemodel);
			}
			else {JOptionPane.showMessageDialog(null,"Il faut cocher un type de document!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}
		});
		btnFiltrer.setBounds(428, 7, 153, 29);
		panel_1.add(btnFiltrer);
		
		JButton btnToutLesDocuments = new JButton("Tout les Documents");
		btnToutLesDocuments.setAutoscrolls(true);
		btnToutLesDocuments.setBounds(428, 44, 153, 29);
		panel_1.add(btnToutLesDocuments);
		btnToutLesDocuments.setBackground(SystemColor.controlHighlight);
		ButtonGroup btngroup=new ButtonGroup();
		
		btngroup.add(rdbtnDevis);
		btngroup.add(rdbtnFacture);
		btngroup.add(rdbtnBonLivraison);
		btnToutLesDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btngroup.clearSelection();
				db_documentvente.mytablemodel=new Document_venteModel(ConnectionDataBase.executeQuery("select * from document_vente"));
				table.setModel(db_documentvente.mytablemodel);
				
			}
		});
		
		
	}
}
