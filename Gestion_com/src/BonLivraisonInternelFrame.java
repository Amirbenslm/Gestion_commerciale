import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ControlerPack.Bon_livraison_venteBase;
import ControlerPack.PaiementModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;

public class BonLivraisonInternelFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BonLivraisonInternelFrame frame = new BonLivraisonInternelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	private Bon_livraison_venteBase db_bonlivraisonvente;

	/**
	 * Create the frame.
	 */
	public BonLivraisonInternelFrame() {
		setBounds(100, 100, 450, 300);
		this.setBorder(null);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 1198, 685);
		this.setVisible(true);
		db_bonlivraisonvente=new Bon_livraison_venteBase();
		getContentPane().setLayout(null);
		table=new JTable();
		table.setModel(db_bonlivraisonvente.mytablemodel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 123, 1106, 446);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 11, 1159, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(0, 11, 108, 74);
		panel.add(btnAjouter);

	}
}
