import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.PaiementModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Paiement extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paiement frame = new Paiement();
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
	public Paiement() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 683, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table=new JTable();
		table.setModel(new PaiementModel(null));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(77, 49, 515, 217);
		contentPane.add(scrollPane);
	}
}
