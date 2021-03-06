

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;
import ControlerPack.Document_venteBase;
import ControlerPack.Document_venteModel;
import ControlerPack.FactureBase;
import classPack.Document_vente;
import classPack.Facture;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class FactureNouveau extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private DefaultComboBoxModel<String> dcm;
	protected ResultSet rsrech;
JTable table=new JTable();
	/**
	 * Launch the application.
	 */
protected Document_venteModel mytablemodel;
	protected int id_doc;
	private Document_vente document;
	private Document_venteBase db_docVente;
	private Facture facture;
	private JTextField textRetourSource;
	private JTextField textTaxeFiscale;
	private JTextField textFodec;
	
	

	/**
	 * Create the frame.
	 * @param db_Facture 
	 */
	public FactureNouveau(FactureBase db_Facture) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 793, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dat = dateFormat.format(actuelle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 757, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
				
				 StringTokenizer st = new StringTokenizer((String)comboBox.getSelectedItem(),"   ");  
			     String     id_client=st.nextToken();
				rsrech=ConnectionDataBase.executeQuery("select * from document_vente where type_doc= 'BL' and id_client= "+Integer.parseInt(id_client) );
				mytablemodel=new Document_venteModel(rsrech);
				table.setModel(mytablemodel);
			}
		});
		comboBox.setBounds(78, 26, 252, 34);
		panel.add(comboBox);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblClient.setBounds(10, 25, 78, 34);
		panel.add(lblClient);
		
		JLabel lblRetourSource = new JLabel("Retour Source ");
		lblRetourSource.setBounds(386, 11, 100, 21);
		panel.add(lblRetourSource);
		
		JLabel lblTaxe = new JLabel("Taxe Fiscale");
		lblTaxe.setBounds(386, 39, 100, 21);
		panel.add(lblTaxe);
		
		JLabel lblFodec = new JLabel("Fodec");
		lblFodec.setBounds(386, 71, 100, 21);
		panel.add(lblFodec);
		
		textRetourSource = new JTextField();
		textRetourSource.setBounds(496, 11, 104, 20);
		panel.add(textRetourSource);
		textRetourSource.setColumns(10);
		
		textTaxeFiscale = new JTextField();
		textTaxeFiscale.setBounds(496, 40, 104, 20);
		panel.add(textTaxeFiscale);
		textTaxeFiscale.setColumns(10);
		
		textFodec = new JTextField();
		textFodec.setBounds(496, 71, 104, 20);
		panel.add(textFodec);
		textFodec.setColumns(10);
		textFodec.setText("10");
		textRetourSource.setText("10");
		textTaxeFiscale.setText("10");
		JButton btnSauvgarder = new JButton("Sauvegarder");
		btnSauvgarder.setBackground(SystemColor.controlHighlight);
		btnSauvgarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ConnectionDataBase.executeUpdate("update facture set retour_source ="+Float.parseFloat(textRetourSource.getText())+ ", t_fiscale ="+Float.parseFloat(textTaxeFiscale.getText())+", fodec ="+Float.parseFloat(textFodec.getText())+" where id_facture ="+facture.getId_facture());
			
			}
			
		});
		btnSauvgarder.setBounds(620, 28, 119, 31);
		panel.add(btnSauvgarder);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new LineBorder(SystemColor.textHighlight));
		scrollPane.setBounds(10, 138, 757, 256);
		contentPane.add(scrollPane);
		
		JButton btnFacturer = new JButton("Facturer");
		btnFacturer.setBackground(SystemColor.controlHighlight);
		btnFacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 document=new Document_vente(0, dat,"F",2);
				 db_docVente=new Document_venteBase();
				document=db_docVente.AjoutDocument_vente(document);
				facture=new Facture(0,"Fact"+document.getId_documentV(),10,10,10,document.getId_documentV());
				facture=db_Facture.AjoutFacture(facture);
			int[] tab=table.getSelectedRows();
			
			int i=0;
			while(i<tab.length)
			{
			id_doc=mytablemodel.getDoc((int)mytablemodel.getValueAt(tab[i], 0)).getId_documentV();
			ConnectionDataBase.executeUpdate("update bon_livraison_vente set id_facture="+facture.getId_facture()+" where id_doc_vente="+id_doc);
			i++;
			}
			JOptionPane.showMessageDialog(null,"Facture ID: "+facture.getId_facture()+"  Reference: "+facture.getReference()+"  est  enregistr�","Succ�ss",JOptionPane.INFORMATION_MESSAGE);	

			}
		});
		btnFacturer.setBounds(415, 437, 124, 39);
		contentPane.add(btnFacturer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(SystemColor.controlHighlight);
		btnAnnuler.setBounds(563, 437, 124, 39);
		contentPane.add(btnAnnuler);
	}
}
