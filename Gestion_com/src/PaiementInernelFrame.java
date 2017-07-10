import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ControlerPack.PaiementModel;

public class PaiementInernelFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaiementInernelFrame frame = new PaiementInernelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;

	/**
	 * Create the frame.
	 */
	public PaiementInernelFrame() {
		setBounds(100, 100, 450, 300);
		this.setBorder(null);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 1198, 685);
		this.setVisible(true);
		
		getContentPane().setLayout(null);
		table=new JTable();
		table.setModel(new PaiementModel(null));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 123, 1106, 446);
		getContentPane().add(scrollPane);

	}

}
