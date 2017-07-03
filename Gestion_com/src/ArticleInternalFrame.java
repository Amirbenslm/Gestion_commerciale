import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import ControlerPack.ArticleBase;
import ControlerPack.ArticleModel;
import ControlerPack.ConnectionDataBase;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArticleInternalFrame extends JInternalFrame {

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
	public static ArticleModel mytablemodel;
	private JTextField textField;
	private JTable table;
	
	//public ArticleModel mytablemodel=ab.mytablemodel;
	/**
	 * Create the frame.
	 */
	public ArticleInternalFrame() {
		 ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		ArticleBase ab=new ArticleBase();
		setBounds(100, 100, 450, 300);
		this.setBorder(null);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 1198, 685);
		this.setVisible(true);
		
		this.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 191, 255)));
		panel_2.setBounds(10, 85, 370, 81);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 255, 28);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(281, 25, 56, 26);
		panel_2.add(btnNewButton_4);
		
		
		table = new JTable();
		
		mytablemodel=ab.mytablemodel;
		
		table.setModel(mytablemodel);
		
		
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
		ArticleAjout FenetreAritcle =new ArticleAjout();
		FenetreAritcle.setVisible(true);
		
	}
});
btnNewButton_1.setBounds(3, 3, 108, 74);
panel.add(btnNewButton_1);
btnNewButton_1.setBackground(SystemColor.controlHighlight);

JButton btnNewButton_2 = new JButton("Modifier");
btnNewButton_2.setBounds(108, 3, 108, 74);
panel.add(btnNewButton_2);
btnNewButton_2.setBackground(SystemColor.controlHighlight);

JButton btnNewButton_3 = new JButton("Supprimer");
btnNewButton_3.setBounds(214, 3, 108, 74);
panel.add(btnNewButton_3);
btnNewButton_3.setBackground(SystemColor.controlHighlight);

	}
}
