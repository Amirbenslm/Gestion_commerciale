import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;
import ControlerPack.FamilleBase;
import ControlerPack.FamilleModel;
import classPack.Famille;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Familles extends JFrame implements MouseListener {

	private JPanel contentPane;
	FamilleBase db_famille=null;
	JTable table;
	private JTextField textRecherche;
	private ResultSet rsrech;
	private JComboBox cb_Recherche;
	/**
	 * Launch the application.
	 */
	private FamilleModel rechercheModel;


	/**
	 * Create the frame.
	 */
	public Familles() {
		setResizable(false);
		setTitle("Familles");
		
		
		db_famille=new FamilleBase();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 528, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table= new JTable();
		table.setModel(db_famille.mytablemodel);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 87, 463, 179);
		contentPane.add(scrollPane);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(SystemColor.controlHighlight);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FamilleAjout familleAjout=new FamilleAjout(db_famille);
				familleAjout.setVisible(true);
			}
		});
		btnAjouter.setBounds(169, 288, 91, 33);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(SystemColor.controlHighlight);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Famille f1= db_famille.getFamille((int) table.getModel().getValueAt(table.getSelectedRow(),0));
				FamilleModifier fm=new FamilleModifier(db_famille, f1);
				fm.setVisible(true);
			
			}
			else
		{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne ou bien Double click sur la ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
	
		}
		});
		btnModifier.setBounds(268, 288, 91, 33);
		contentPane.add(btnModifier);
		
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
				db_famille.supprimerFamille((int)table.getModel().getValueAt(table.getSelectedRow(),0));
					 	}
			
			}
			else
		{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
	
		}
			
		});
		btnSupprimer.setBounds(367, 288, 101, 33);
		contentPane.add(btnSupprimer);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBounds(28, 11, 463, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 cb_Recherche = new JComboBox();
		cb_Recherche.setModel(new DefaultComboBoxModel(new String[] {"Nom Famille", "Taxe"}));
		cb_Recherche.setBounds(10, 27, 110, 33);
		panel.add(cb_Recherche);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db_famille.mytablemodel=new FamilleModel(ConnectionDataBase.executeQuery("select * from famille"));
				table.setModel(db_famille.mytablemodel);
			}
		});
		Image imgrefresh=new ImageIcon(this.getClass().getResource("/Refresh.png")).getImage();
		btnRefresh.setIcon(new ImageIcon(imgrefresh));
		btnRefresh.setBounds(138, 27, 56, 33);
		panel.add(btnRefresh);
		
		textRecherche = new JTextField();
		textRecherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			search();}
		});
		
		textRecherche.setBounds(203, 27, 152, 33);
		panel.add(textRecherche);
		textRecherche.setColumns(10);
		
		JButton btnRecherche = new JButton("");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		btnRecherche.setBounds(365, 27, 56, 33);
		Image imgrecherche=new ImageIcon(this.getClass().getResource("/Recherche.png")).getImage();
		btnRecherche.setIcon(new ImageIcon(imgrecherche));
		panel.add(btnRecherche);
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
if (e.getClickCount() == 2){
			
	Famille f1= db_famille.getFamille((int)table.getModel().getValueAt(table.getSelectedRow(),0));
	FamilleModifier fm=new FamilleModifier(db_famille, f1);
	fm.setVisible(true);
		}
		
	}
		
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void search()
	{String req = null ;
	
	String	 s=textRecherche.getText();
			if(cb_Recherche.getSelectedItem().toString().equals("Nom Famille"))
			{ req = "select * from famille where nom_famille LIKE '%"+s+"%'";	
			}
			if(cb_Recherche.getSelectedItem().toString().equals("Taxe"))
			{ req = "select * from famille where   id_taxe="+Float.parseFloat(s);
				
			}
			
			rsrech=ConnectionDataBase.executeQuery(req);
			rechercheModel=new FamilleModel(rsrech);
			
			db_famille.mytablemodel=rechercheModel;
			table.setModel(db_famille.mytablemodel);
		
		
		
	
	}
}
