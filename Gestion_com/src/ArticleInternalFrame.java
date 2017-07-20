import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import ControlerPack.ArticleBase;
import ControlerPack.ArticleModel;
import ControlerPack.ConnectionDataBase;
import ControlerPack.TaxeModel;
import classPack.Article;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class ArticleInternalFrame extends JInternalFrame implements MouseListener {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleInternalFrame frame = new ArticleInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextField textRecherche;
	private JTable table;
	ArticleBase db_article=null;
	private JComboBox<String> cb_Recherche;
	private String req,s;
	ResultSet rsrech;
	private ArticleModel rechercheModel;
	/**
	 * Create the frame.
	 */
	public ArticleInternalFrame() {
		setTitle("Article");
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		 db_article=new ArticleBase();
		setBounds(100, 100, 450, 300);
		this.setBorder(null);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 1198, 685);
		this.setVisible(true);
		
		this.getContentPane().setLayout(null);

		 cb_Recherche = new JComboBox<String>();
		cb_Recherche.setModel(new DefaultComboBoxModel(new String[] {"R\u00E9ference", "Designation", "Code Abarre", "Famille", "Taxe"}));
		cb_Recherche.setBounds(21, 25, 133, 33);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 191, 255)));
		panel_2.setBounds(10, 85, 563, 81);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(cb_Recherche);
		textRecherche = new JTextField();
		textRecherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		textRecherche.setBounds(232, 25, 255, 33);
		panel_2.add(textRecherche);
		textRecherche.setColumns(10);
		
		JButton btnRechercher = new JButton("");
		
		Image imgrecherche=new ImageIcon(this.getClass().getResource("/Recherche.png")).getImage();
		btnRechercher.setIcon(new ImageIcon(imgrecherche));
		btnRechercher.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				search();
			}
			});
		btnRechercher.setBounds(497, 25, 56, 33);
		panel_2.add(btnRechercher);
		
		JButton btnReturn = new JButton("");
		Image imgrefresh=new ImageIcon(this.getClass().getResource("/Refresh.png")).getImage();
		btnReturn.setIcon(new ImageIcon(imgrefresh));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				db_article.mytablemodel=new ArticleModel(ConnectionDataBase.executeQuery("select *from article"));
				table.setModel(db_article.mytablemodel);
			}
		});
		btnReturn.setBounds(179, 25, 45, 33);
		panel_2.add(btnReturn);
		
		
		
		table = new JTable();
		
		
		
		table.setModel(db_article.mytablemodel);
		
		table.addMouseListener(this);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 171, 1178, 476);
		
getContentPane().add(scrollPane);
JPanel panel = new JPanel();
panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
panel.setBounds(10, 2, 1178, 81);
getContentPane().add(panel);
panel.setLayout(null);

JButton btnNewButton_1 = new JButton("Ajouter");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		ArticleAjout FenetreAritcle =new ArticleAjout(db_article);
		FenetreAritcle.setVisible(true);
		
	}
});
btnNewButton_1.setBounds(3, 3, 108, 74);
panel.add(btnNewButton_1);
btnNewButton_1.setBackground(SystemColor.controlHighlight);

JButton btnNewButton_2 = new JButton("Modifier");
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
		if(table.isRowSelected(table.getSelectedRow()))
		{
		Article a1= db_article.getArticle((int)table.getModel().getValueAt(table.getSelectedRow(),0));
		ArticleModifier articlemodifier=new ArticleModifier(db_article,a1,table.getModel());
	
	}
	else
	{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
}

});
btnNewButton_2.setBounds(108, 3, 108, 74);
panel.add(btnNewButton_2);
btnNewButton_2.setBackground(SystemColor.controlHighlight);

JButton btnNewButton_3 = new JButton("Supprimer");
btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(table.isRowSelected(table.getSelectedRow()))
		{
			
			db_article.supprimerArticle((int)table.getModel().getValueAt(table.getSelectedRow(),0));
		}
		else
		{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
	}
	
});



btnNewButton_3.setBounds(214, 3, 108, 74);
panel.add(btnNewButton_3);
btnNewButton_3.setBackground(SystemColor.controlHighlight);
JButton btnVendre = new JButton("Vendre");
btnVendre.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(table.isRowSelected(table.getSelectedRow()))
		{		
			Article art1= db_article.getArticle((int)table.getModel().getValueAt(table.getSelectedRow(),0));
		ArticleVendre articlevendu=new ArticleVendre(art1);
		articlevendu.setVisible(true);
	}else
	{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
}
});
btnVendre.setBackground(SystemColor.controlHighlight);
btnVendre.setBounds(320, 3, 108, 74);
panel.add(btnVendre);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2){
			
			Article a1= db_article.getArticle((int)table.getModel().getValueAt(table.getSelectedRow(),0));
			ArticleModifier articlemodifier=new ArticleModifier(db_article,a1,table.getModel());
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
	{
		 s=textRecherche.getText();
			if(cb_Recherche.getSelectedItem().toString().equals("R\u00E9ference"))
			{ req = "select * from article where reference LIKE '%"+s+"%'";	
			}
			if(cb_Recherche.getSelectedItem().toString().equals("Designation"))
			{ req = "select * from article where designation LIKE '%"+s+"%'";
				
			}
			if(cb_Recherche.getSelectedItem().toString().equals("Code Abarre"))
			{ req = "select * from article where code_abar LIKE '%"+s+"%'";
			}
			if(cb_Recherche.getSelectedItem().toString().equals("Famille"))
			{ req = "select * from article where  id_famille="+Float.parseFloat(s);
			;}
			if(cb_Recherche.getSelectedItem().toString().equals("Taxe"))
			{ req = "select * from article where  id_taxe="+Float.parseFloat(s);
			}
			rsrech=ConnectionDataBase.executeQuery(req);
			rechercheModel=new ArticleModel(rsrech);
			
			db_article.mytablemodel=rechercheModel;
			table.setModel(db_article.mytablemodel);
		
		
		
	
	}	
}
