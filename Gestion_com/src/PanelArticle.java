import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Article.AjoutArticle;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class PanelArticle extends JPanel {
	public JButton btnAjouterArticle;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public PanelArticle() {
		setLayout(null);
		
		 btnAjouterArticle = new JButton("Ajouter");
		 btnAjouterArticle.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		new AjoutArticle();
		 	}
		 });
		btnAjouterArticle.setBounds(0, 0, 101, 68);
		add(btnAjouterArticle);
		
		JButton btnNewButton = new JButton("Modifier ");
		btnNewButton.setBounds(99, 0, 101, 68);
		add(btnNewButton);
		
		JButton btnSupprimerArticle = new JButton("Supprimer ");
		btnSupprimerArticle.setBounds(198, 0, 101, 68);
		add(btnSupprimerArticle);
		
		textField = new JTextField();
		textField.setBounds(10, 99, 299, 79);
		add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(27, 203, 109, 23);
		add(rdbtnNewRadioButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(179, 203, 97, 23);
		add(chckbxNewCheckBox);

	}
}
