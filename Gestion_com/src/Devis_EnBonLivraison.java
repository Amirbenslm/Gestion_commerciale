import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.Bon_livraison_venteBase;
import ControlerPack.ConnectionDataBase;
import ControlerPack.DevisBase;
import ControlerPack.Document_venteBase;
import ControlerPack.Document_venteModel;
import classPack.Bon_livraison_vente;
import classPack.Devis;
import classPack.Document_vente;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Devis_EnBonLivraison extends JFrame {

	private JPanel contentPane;
	private DefaultComboBoxModel<String> dcm;
	protected ResultSet rsrech;
	
	protected JTable table;
	private JComboBox comboBox;
Document_venteBase db_documentvente=new Document_venteBase();
	/**
	 * Launch the application.
	 */
protected int id_doc;
	private Document_vente document;
	private DevisBase db_devis;
	private Bon_livraison_vente bonlivraison;
	private Bon_livraison_venteBase db_bonlivraison;


	/**
	 * Create the frame.
	 */
	public Devis_EnBonLivraison() {
		setTitle("Devis ====> Bon Livraison");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 738, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dat = dateFormat.format(actuelle);
		 document=new Document_vente(0, dat,"F",2);
		 db_documentvente=new Document_venteBase();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 712, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		table=new JTable();
		 
		 dcm = new DefaultComboBoxModel<String>();
			ResultSet rs=ConnectionDataBase.executeQuery("select * from client");
			
			try {
				while(rs.next())
				{dcm.addElement(rs.getInt(1)+" "+rs.getString("nom")+"   "+rs.getString("prenom"));
				
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 comboBox = new JComboBox(dcm);
			comboBox.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
					document=db_documentvente.AjoutDocument_vente(document);
					bonlivraison=new Bon_livraison_vente(0,"BL"+document.getId_documentV(),document.getId_documentV(),0);
					db_bonlivraison= new Bon_livraison_venteBase();
					db_bonlivraison.AjoutBon_livraison_vente(bonlivraison);
					
					 StringTokenizer st = new StringTokenizer((String)comboBox.getSelectedItem(),"   ");  
				     String     id_client=st.nextToken();
					rsrech=ConnectionDataBase.executeQuery("select * from document_vente where type_doc= 'D' and id_client= "+Integer.parseInt(id_client) );
					db_documentvente.mytablemodel=new Document_venteModel(rsrech);
					table.setModel(db_documentvente.mytablemodel);
				}
			});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(109, 29, 217, 37);
		panel.add(comboBox);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClient.setBounds(10, 34, 89, 27);
		panel.add(lblClient);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.textHighlight));
		scrollPane.setBounds(10, 115, 712, 252);
		contentPane.add(scrollPane);
		
		JButton btnbonLivraison = new JButton("Bon Livraison");
		btnbonLivraison.setBackground(SystemColor.controlHighlight);
		btnbonLivraison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] tab=table.getSelectedRows();
				
				int i=0;
				while(i<tab.length)
				{
				id_doc=db_documentvente.mytablemodel.getDoc((int)db_documentvente.mytablemodel.getValueAt(tab[i], 0)).getId_documentV();
				ConnectionDataBase.executeUpdate("update devis set id_bon_livraison="+bonlivraison.getId_bon_livraison()+" where id_doc_vente="+id_doc);
				i++;
				}
				JOptionPane.showMessageDialog(null,"Bon Livraison ID: "+bonlivraison.getId_bon_livraison()+"  Reference: "+bonlivraison.getRef_bon_livraison()+"  est  enregistré","Succéss",JOptionPane.INFORMATION_MESSAGE);	
				}
			
		});
		btnbonLivraison.setBounds(426, 396, 121, 35);
		contentPane.add(btnbonLivraison);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(SystemColor.controlHighlight);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setBounds(581, 396, 121, 35);
		contentPane.add(btnAnnuler);
	}
}
