import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Infos_Entreprise extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Infos_Entreprise frame = new Infos_Entreprise();
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
	public Infos_Entreprise() {
		setTitle("A propos Entreprise");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 15, 77, 138);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5,0));
		
		JLabel lblNewLabel = new JLabel("Raison Social");
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel(" Activit\u00E9");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Compl\u00E9ment");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("CP / Ville");
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(101, 15, 399, 138);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 0, 0, 5));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRegionpays = new JLabel("Region/Pays");
		lblRegionpays.setBounds(10, 160, 77, 14);
		contentPane.add(lblRegionpays);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 160, 176, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Afrique du Sud", "Albanie", "Alg\u00E9rie", "Allemagne", "Angola", "Arabie saoudite", "Argentine", "Belgique", "Bermudes", "Bi\u00E9lorussie", "Br\u00E9sil", "Canada", "Cap-Vert", "Chili", "Chine", "Chypre", "Clipperton Island", "Colombie", "Comores", "Congo", "Coral Sea Islands", "Cor\u00E9e du Nord", "Cor\u00E9e du Sud", "Costa Rica", "C\u00F4te d'Ivoire", "Croatie", "Cuba", "Danemark", "Dhekelia", "Djibouti", "Dominique", "\u00C9gypte", "\u00C9mirats arabes unis", "\u00C9quateur", "\u00C9rythr\u00E9e", "Espagne", "Estonie", "\u00C9tats-Unis", "\u00C9thiopie", "ex-R\u00E9publique yougoslave de Mac\u00E9doine", "Finlande", "France", "Gabon", "Gambie", "Gaza Strip", "G\u00E9orgie", "Ghana", "Gibraltar", "Gr\u00E8ce", "Guam", "Guatemala", "Guin\u00E9e", "Guin\u00E9e \u00E9quatoriale", "Guin\u00E9e-Bissao", "Guyana", "Ha\u00EFti", "Hong Kong", "Indon\u00E9sie", "Iran", "Iraq", "Irlande", "Islande", "Italie", "Jama\u00EFque", "Japon", "Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kowe\u00EFt", "Liban", "Liberia", "Libye", "Liechtenstein", "Lituanie", "Luxembourg", "Macao", "Madagascar", "Malaisie", "Malawi", "Maldives", "Mali", "Malte", "Maroc", "Mauritanie", "Mayotte", "Mexique", "Moldavie", "Monaco", "Mongolie", "Mozambique", "Niger", "Nigeria", "Niou\u00E9", "Norv\u00E8ge", "Oman", "Ouganda", "Ouzb\u00E9kistan", "Pacific Ocean", "Pakistan", "Panama", "Paraguay", "Pays-Bas", "P\u00E9rou", "Pologne", "Porto Rico", "Portugal", "Qatar", "Roumanie", "Royaume-Uni", "Russie", "Rwanda", "Salvador", "Samoa", "Samoa am\u00E9ricaines", "Sao Tom\u00E9-et-Principe", "S\u00E9n\u00E9gal", "Serbie", "Singapour", "Slovaquie", "Slov\u00E9nie", "Somalie", "Soudan", "Su\u00E8de", "Suisse", "Suriname", "Swaziland", "Syrie", "Tadjikistan", "Ta\u00EFwan", "Tanzanie", "Tchad", "Tha\u00EFlande", "Togo", "Tok\u00E9laou", "Tonga", "Trinit\u00E9-et-Tobago", "Tunisie", "Turkm\u00E9nistan", "Turquie", "Ukraine", "Venezuela", "Vi\u00EAt Nam", "Y\u00E9men", "Zambie", "Zimbabwe"}));
		comboBox.setBounds(287, 160, 213, 20);
		contentPane.add(comboBox);
		
		JLabel lblSiret = new JLabel(" SIRET");
		lblSiret.setBounds(10, 191, 77, 14);
		contentPane.add(lblSiret);
		
		textField_6 = new JTextField();
		textField_6.setBounds(101, 191, 176, 23);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNaf = new JLabel("NAF");
		lblNaf.setBounds(287, 191, 36, 14);
		contentPane.add(lblNaf);
		
		textField_7 = new JTextField();
		textField_7.setBounds(316, 188, 184, 23);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("T\u00E9lecomunication  :");
		lblNewLabel_5.setBounds(10, 216, 128, 29);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblTlephone = new JLabel("T\u00E9lephone");
		lblTlephone.setBounds(10, 256, 77, 20);
		contentPane.add(lblTlephone);
		
		textField_8 = new JTextField();
		textField_8.setBounds(101, 256, 176, 23);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setBounds(287, 259, 46, 14);
		contentPane.add(lblFax);
		
		textField_9 = new JTextField();
		textField_9.setBounds(316, 256, 184, 23);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 287, 46, 14);
		contentPane.add(lblEmail);
		
		textField_10 = new JTextField();
		textField_10.setBounds(101, 287, 401, 23);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setBounds(10, 320, 46, 14);
		contentPane.add(lblSite);
		
		textField_11 = new JTextField();
		textField_11.setBounds(101, 317, 399, 23);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fw = new FileWriter ("infos_entreprise.txt");
					BufferedWriter bw = new BufferedWriter (fw);
					PrintWriter fichierSortie = new PrintWriter (bw); 
						fichierSortie.println(textField.getText());
						fichierSortie.println(textField_1.getText());
						fichierSortie.println(textField_2.getText());
						fichierSortie.println(textField_3.getText());
						fichierSortie.println(textField_4.getText());
						fichierSortie.println(textField_5.getText());
						fichierSortie.println(comboBox.getSelectedItem().toString());
						
						fichierSortie.println(textField_6.getText());
						fichierSortie.println(textField_7.getText());
						fichierSortie.println(textField_8.getText());
						fichierSortie.println(textField_9.getText());
						fichierSortie.println(textField_10.getText());
						fichierSortie.println(textField_11.getText());
						
						
						fichierSortie.close();
					System.out.println("Le fichier " + "infos_entreprise.txt" + " a été créé!"); 
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}		
			}
		});
		/******Lire dapres Fichier*****************************/
		try{
			InputStream ips=new FileInputStream("infos_entreprise.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			textField.setText(br.readLine());
			textField_1.setText(br.readLine());
			textField_2.setText(br.readLine());
			textField_3.setText(br.readLine());
			textField_4.setText(br.readLine());
			textField_5.setText(br.readLine());
			textField_6.setText(br.readLine());
			textField_7.setText(br.readLine());
			textField_8.setText(br.readLine());
			textField_9.setText(br.readLine());
			textField_10.setText(br.readLine());
			textField_11.setText(br.readLine());
			
				
				
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		btnNewButton.setBounds(175, 358, 102, 29);
		contentPane.add(btnNewButton);
		this.setVisible(true);
	}
}
