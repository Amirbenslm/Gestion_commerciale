import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ControlerPack.ConnectionDataBase;
import ControlerPack.TaxeBase;
import ControlerPack.TaxeModel;
import classPack.Taxe;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Taxes extends JFrame implements MouseListener {
	public TaxeBase db_taxe;
	private JPanel contentPane;
public	JTable table;
	private JTextField textRecherche;
	JComboBox cb_Recherche;
	private ResultSet rsrech;
	private TaxeModel rechercheModel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taxes frame = new Taxes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Taxes()  {
		
		setTitle("Taxes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 390);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 db_taxe=new TaxeBase();
		 table=new JTable();
		 
		table.setModel(db_taxe.mytablemodel);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(42, 87, 572, 202);
		contentPane.add(scrollPane);
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxeAjout ta=new TaxeAjout(db_taxe);
				ta.setVisible(true);
			}
		});
		Ajouter.setBounds(288, 300, 91, 31);
		contentPane.add(Ajouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Taxe taxe= db_taxe.getTaxe((int)table.getModel().getValueAt(table.getSelectedRow(),0));
				TaxeModifier tm=new TaxeModifier(db_taxe,taxe,rechercheModel);
				tm.setVisible(true);
			}
				else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne ou bien Double click sur la ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}});
		btnModifier.setBounds(404, 300, 91, 31);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.isRowSelected(table.getSelectedRow()))
				{
					
					db_taxe.supprimerTaxe((int)table.getModel().getValueAt(table.getSelectedRow(),0));
				}
				else
				{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}
		});
		btnSupprimer.setBounds(520, 300, 98, 31);
		contentPane.add(btnSupprimer);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBounds(42, 11, 572, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 cb_Recherche = new JComboBox();
		cb_Recherche.setModel(new DefaultComboBoxModel(new String[] {"Libell\u00E9", "Taux"}));
		cb_Recherche.setBounds(10, 30, 125, 30);
		panel.add(cb_Recherche);
		
		textRecherche = new JTextField();
		textRecherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		textRecherche.setBounds(214, 30, 168, 30);
		panel.add(textRecherche);
		textRecherche.setColumns(10);
		
		JButton btnRefresh = new JButton("");
		Image imgrefresh=new ImageIcon(this.getClass().getResource("/Refresh.png")).getImage();
		btnRefresh.setIcon(new ImageIcon(imgrefresh));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db_taxe.mytablemodel=new TaxeModel(ConnectionDataBase.executeQuery("select * from taxe"));
				table.setModel(db_taxe.mytablemodel);
			}
		});
		btnRefresh.setBounds(162, 30, 39, 30);
		panel.add(btnRefresh);
		
		JButton btnRechercher = new JButton("");
		Image imgrecherche=new ImageIcon(this.getClass().getResource("/Recherche.png")).getImage();
		btnRechercher.setIcon(new ImageIcon(imgrecherche));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {search();
			}
		});
		btnRechercher.setBounds(390, 30, 39, 30);
		panel.add(btnRechercher);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2){
			
			Taxe taxe= db_taxe.getTaxe((int)table.getModel().getValueAt(table.getSelectedRow(),0));
			TaxeModifier tm=new TaxeModifier(db_taxe,taxe,rechercheModel);
			
			tm.setVisible(true);
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
			if(cb_Recherche.getSelectedItem().toString().equals("Libell\u00E9"))
			{ req = "select * from taxe where libelle LIKE '%"+s+"%'";	
			}
			if(cb_Recherche.getSelectedItem().toString().equals("Taux"))
			{ req = "select * from taxe where  taux ="+Float.parseFloat(s);
				
			}
			
			rsrech=ConnectionDataBase.executeQuery(req);
			rechercheModel=new TaxeModel(rsrech);
			
		db_taxe.mytablemodel=rechercheModel;
		table.setModel(db_taxe.mytablemodel);
		
		
	
	}}

