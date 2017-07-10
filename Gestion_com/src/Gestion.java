import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

import ControlerPack.ConnectionDataBase;

import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import java.awt.Window.Type;

import javax.swing.JTextField;

public class Gestion {

	private JFrame frame;
	JPanel panel,panel1 ;
	private JDesktopPane desktopPane;
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
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		frame = new JFrame();
		frame.setType(Type.POPUP);
		 desktopPane = new JDesktopPane();
			desktopPane.setBounds(164, 0, 1198, 685);
			frame.getContentPane().add(desktopPane);
			
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.getContentPane().setForeground(UIManager.getColor("Button.shadow"));
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
		mntmFamilles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Familles famille=new Familles();
				famille.setVisible(true);
			}
		});
		mnStructure.add(mntmFamilles);
		
		JMenuItem mntmArticles = new JMenuItem("Articles");
		mntmArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleInternalFrame aif2=new ArticleInternalFrame();
				desktopPane.add(aif2);
			}
		});
		mnStructure.add(mntmArticles);
		
		JMenuItem mntmTaxes = new JMenuItem("Taxes");
		mntmTaxes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Taxes taxeframe=new Taxes();
				taxeframe.setVisible(true);
			}
		});
		mnStructure.add(mntmTaxes);
		
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
		Image img=new ImageIcon(this.getClass().getResource("/articles.png")).getImage();
		Image imgclient=new ImageIcon(this.getClass().getResource("/client.png")).getImage();
	
		
		Image imgfour=new ImageIcon(this.getClass().getResource("/four.png")).getImage();
		Image imgfac=new ImageIcon(this.getClass().getResource("/facture.png")).getImage();
		Image imgcom=new ImageIcon(this.getClass().getResource("/commande.png")).getImage();
		Image imgdevis=new ImageIcon(this.getClass().getResource("/devis.png")).getImage();
		Image imgpai=new ImageIcon(this.getClass().getResource("/paiement.png")).getImage();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 163, 685);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(8, 1, 0, 0));
		
		JButton barticle = new JButton("Articles");
		panel_1.add(barticle);
		barticle.setHorizontalTextPosition(SwingConstants.CENTER);
		barticle.setBackground(SystemColor.controlHighlight);
		barticle.setIcon(new ImageIcon(img));
		barticle.setVerticalTextPosition(SwingConstants.BOTTOM);
		barticle.setVerticalAlignment(SwingConstants.TOP);
		
		JButton bclient = new JButton("Clients");
		panel_1.add(bclient);
		bclient.setBackground(SystemColor.controlHighlight);
		bclient.setIcon(new ImageIcon(imgclient));
		//btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		bclient.setVerticalTextPosition(SwingConstants.BOTTOM);
		bclient.setHorizontalTextPosition(SwingConstants.CENTER);
		//btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		bclient.setForeground(Color.BLACK);
		
		JButton bfourisseur = new JButton("Fournisseurs");
		panel_1.add(bfourisseur);
		bfourisseur.setBackground(SystemColor.controlHighlight);
		bfourisseur.setIcon(new ImageIcon(imgfour));
		bfourisseur.setVerticalTextPosition(SwingConstants.BOTTOM);
		bfourisseur.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton bpaiement = new JButton("Paiement");
		panel_1.add(bpaiement);
		bpaiement.setBackground(SystemColor.controlHighlight);
		bpaiement.setIcon(new ImageIcon(imgpai));
		bpaiement.setVerticalTextPosition(SwingConstants.BOTTOM);
		bpaiement.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton bfacture = new JButton("Facture");
		panel_1.add(bfacture);
		bfacture.setBackground(SystemColor.controlHighlight);
		bfacture.setIcon(new ImageIcon(imgfac));
		bfacture.setVerticalTextPosition(SwingConstants.BOTTOM);
		bfacture.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton bcommande = new JButton("Bon  Commande");
		panel_1.add(bcommande);
		bcommande.setBackground(SystemColor.controlHighlight);
		bcommande.setIcon(new ImageIcon(imgcom));
		bcommande.setVerticalTextPosition(SwingConstants.BOTTOM);
		bcommande.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton blivraison = new JButton("Bon Livraison");
		Image imageliv=new ImageIcon(this.getClass().getResource("/liv.png")).getImage();
		blivraison.setIcon(new ImageIcon(imageliv));
		blivraison.setVerticalTextPosition(SwingConstants.BOTTOM);
		blivraison.setHorizontalTextPosition(SwingConstants.CENTER);
		blivraison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		blivraison.setBackground(SystemColor.controlHighlight);
		panel_1.add(blivraison);
		
		JButton bdevis = new JButton("Devis");
		panel_1.add(bdevis);
		bdevis.setBackground(SystemColor.controlHighlight);
		bdevis.setIcon(new ImageIcon(imgdevis));
		bdevis.setVerticalTextPosition(SwingConstants.BOTTOM);
		bdevis.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		bdevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bcommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bfacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bpaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaiementInernelFrame  paiInternelFram =new PaiementInernelFrame();
				paiInternelFram.setVisible(true);
				desktopPane.add(paiInternelFram);
			}
		});
		bfourisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleInternalFrame aif2=new ArticleInternalFrame();
				desktopPane.add(aif2);
			}
		});
		bclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			
			}
		});
		barticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleInternalFrame aif=new ArticleInternalFrame();
				desktopPane.add(aif);
				
			}
		});
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
