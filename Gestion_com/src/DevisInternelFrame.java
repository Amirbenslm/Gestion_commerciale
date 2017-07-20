import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ControlerPack.DevisBase;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DevisInternelFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevisInternelFrame frame = new DevisInternelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	private DevisBase db_devis;

	/**
	 * Create the frame.
	 */
	public DevisInternelFrame() {
		db_devis=new DevisBase();
		setTitle("Devis");
		setBounds(100, 100, 450, 300);
		this.setBorder(null);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 1198, 685);
		getContentPane().setLayout(null);
		table=new JTable();
		table.setModel(db_devis.mytablemodel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 108, 1178, 381);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 15, 1178, 78);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DevisNouveau().setVisible(true);
			}
		});
		btnNouveau.setBounds(0, 11, 123, 56);
		panel.add(btnNouveau);
		this.setVisible(true);

	}
}
