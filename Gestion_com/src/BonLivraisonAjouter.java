import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class BonLivraisonAjouter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BonLivraisonAjouter frame = new BonLivraisonAjouter();
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
	public BonLivraisonAjouter() {
		setTitle("Bon Livraison");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 722, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(166, 22, 198, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox cb_bonlivraison = new JComboBox();
		cb_bonlivraison.setModel(new DefaultComboBoxModel(new String[] {"Code A barre", "Designation", "Reference"}));
		cb_bonlivraison.setBounds(10, 22, 121, 30);
		panel.add(cb_bonlivraison);
		
		JButton btnNewButton = new JButton("Vendre");
		btnNewButton.setBounds(394, 22, 89, 29);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 722, 161);
		contentPane.add(scrollPane);
	}
}
