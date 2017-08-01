import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.Document_venteBase;
import classPack.Article;
import classPack.Document_vente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Document_VenteFrame extends JFrame {

	private JPanel contentPane;
	private Document_venteBase db_documentvente;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Document_VenteFrame frame = new Document_VenteFrame();
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
	public Document_VenteFrame() {
		setResizable(false);
		setTitle("Document vente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 100, 827, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		db_documentvente=new Document_venteBase();
		table =new JTable();
		table.setModel(db_documentvente.mytablemodel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 95, 791, 343);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 11, 791, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Document_vente a1= db_documentvente.getDocument((int)table.getValueAt(table.getSelectedRow(),0));
				//ArticleModifier articlemodifier=new ArticleModifier(db_article,a1,table.getModel());
			
			}else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}

			 
		});
		btnNewButton.setBounds(0, 11, 112, 57);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
					db_documentvente.supprimerDocument_vente((db_documentvente.getDocument((int)table.getValueAt(table.getSelectedRow(),0))).getId_documentV());
					
			}
			else
			{JOptionPane.showMessageDialog(null,"Il faut sélectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
			
		});
		btnNewButton_1.setBounds(110, 11, 112, 57);
		panel.add(btnNewButton_1);
	}
}
