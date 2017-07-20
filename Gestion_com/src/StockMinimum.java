import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ArticleModel;
import ControlerPack.ConnectionDataBase;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StockMinimum extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockMinimum frame = new StockMinimum();
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
	public StockMinimum() {
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		setTitle("Articles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTable table=new JTable();
		table.setModel(new ArticleModel(ConnectionDataBase.executeQuery("select * from article where qte_stock <= qte_min")));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 47, 776, 258);
		contentPane.add(scrollPane);
	}
}
