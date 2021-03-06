

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import ControlerPack.FamilleBase;
import ControlerPack.TaxeBase;
import classPack.Famille;

import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FamilleAjout extends JFrame {

	private JPanel contentPane;
	private JTextField nomfamille;
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamilleAjout frame = new FamilleAjout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public FamilleAjout(FamilleBase db_famille) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ajouter Famille", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBounds(25, 26, 272, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom famille");
		lblNewLabel.setBounds(24, 27, 80, 30);
		panel.add(lblNewLabel);
		
		JLabel lblTaxe = new JLabel("Taxe");
		lblTaxe.setBounds(24, 87, 60, 31);
		panel.add(lblTaxe);
		
		nomfamille = new JTextField();
		nomfamille.setBounds(114, 32, 128, 25);
		panel.add(nomfamille);
		nomfamille.setColumns(10);
		
		JComboBox cb_taxe = new JComboBox();
		cb_taxe.setBounds(114, 88, 128, 30);
		panel.add(cb_taxe);
		TaxeBase db_taxe=new TaxeBase();
		ResultSet rstaxe=db_taxe.affiche();
		try {
			while(rstaxe.next())
			{
			cb_taxe.addItem(rstaxe.getString(2));	
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(SystemColor.controlHighlight);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_taxe=0;
				ResultSet rsidtaxe=db_taxe.rechercheByLibille(cb_taxe.getSelectedItem().toString());
				try {
					rsidtaxe.next();
				
				id_taxe=rsidtaxe.getInt(1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Famille fam=new Famille(0,nomfamille.getText(),id_taxe);
				db_famille.AjoutFamille(fam);
			}
		});
		btnAjouter.setBounds(94, 193, 89, 33);
		contentPane.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(SystemColor.controlHighlight);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setBounds(208, 193, 89, 33);
		contentPane.add(btnAnnuler);
	}
}
