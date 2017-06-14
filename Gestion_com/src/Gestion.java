import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Gestion {

	private JFrame frame;
	JPanel panel,panel1 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion window = new Gestion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 888, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Fichier");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A propos Entreprise");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Infos_Entreprise();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);}
		});
		mnNewMenu.add(mntmQuitter);
		
		JMenu mnStructure = new JMenu("Structure");
		menuBar.add(mnStructure);
		
		JMenuItem mntmClients = new JMenuItem("Clients");
		mnStructure.add(mntmClients);
		
		JMenuItem mntmFournisseurs = new JMenuItem("Fournisseurs");
		mnStructure.add(mntmFournisseurs);
		
		JMenuItem mntmFamilles = new JMenuItem("Familles d'articles");
		mnStructure.add(mntmFamilles);
		
		JMenuItem mntmArticles = new JMenuItem("Articles");
		mnStructure.add(mntmArticles);
		
		JMenu mnTraitement = new JMenu("Traitement");
		menuBar.add(mnTraitement);
		
		JMenuItem mntmDocumentsVentes = new JMenuItem("Documents ventes");
		mnTraitement.add(mntmDocumentsVentes);
		
		JMenuItem mntmDocumentsAchats = new JMenuItem("Documents achats");
		mnTraitement.add(mntmDocumentsAchats);
		
		JMenuItem mntmGestionDeReception = new JMenuItem("Gestion de reception fourinisseur");
		mnTraitement.add(mntmGestionDeReception);
		
		JMenu mnGestionDeReglement = new JMenu("Gestion de r\u00E9glement");
		mnTraitement.add(mnGestionDeReglement);
		
		JMenuItem mntmSaisieReglementClient = new JMenuItem("Saisie r\u00E9glement client");
		mnGestionDeReglement.add(mntmSaisieReglementClient);
		
		JMenuItem mntmSaisieReglementFournisseur = new JMenuItem("Saisie r\u00E9glement fournisseur");
		mnGestionDeReglement.add(mntmSaisieReglementFournisseur);
		frame.getContentPane().setLayout(null);
		panel=new JPanel();
		panel.setBounds(101, 0, 771, 528);
		
		JButton btnArticle = new JButton("Articles");
		btnArticle.setBackground(Color.WHITE);
		Image img=new ImageIcon(this.getClass().getResource("/articles.png")).getImage();
		btnArticle.setIcon(new ImageIcon(img));
		btnArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.getContentPane().add(new PanelArticle());
			}
		});
		btnArticle.setBounds(0, 0, 133, 99);
		frame.getContentPane().add(btnArticle);
		
		JButton btnNewButton = new JButton("Clients",new ImageIcon("C:\\Users\\Amir\\Documents\\Eclipse\\Gestion_com\\Gestion_com\\Images\\client1.png"));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setForeground(Color.BLACK);
		panel1=new PanelClient();
		panel1.setBounds(101, 0, 771, 528);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().add(panel1);
			
			}
		});
		btnNewButton.setBounds(0, 99, 133, 99);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fournisseurs");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Amir\\Documents\\Eclipse\\Gestion_com\\Gestion_com\\Images\\1497295645_users.png"));
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(0, 199, 133, 108);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Documents");
		btnNewButton_2.setBounds(0, 307, 133, 108);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Paiements");
		btnNewButton_3.setBounds(0, 414, 133, 99);
		frame.getContentPane().add(btnNewButton_3);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
