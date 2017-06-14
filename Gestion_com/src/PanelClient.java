import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelClient extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelClient() {
		setLayout(null);
		
		JButton btnHello = new JButton("Hello");
		btnHello.setBounds(46, 28, 89, 23);
		add(btnHello);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(168, 28, 89, 23);
		add(btnNewButton);

	}
}
