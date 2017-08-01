import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ControlerPack.DevisBase;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

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
		scrollPane.setBounds(10, 104, 1178, 454);
		getContentPane().add(scrollPane);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2)
				{
					new DevisModifier(db_devis.mytablemodel.getDevis((int)db_devis.mytablemodel.getValueAt(table.getSelectedRow(), 0))).setVisible(true);;
				}
				
			}
		});
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 2, 1178, 91);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DevisNouveau(db_devis).setVisible(true);
			}
		});
		btnNouveau.setBounds(2, 6, 123, 80);
		btnNouveau.setBackground(SystemColor.controlHighlight); 
		panel.add(btnNouveau);
		this.setVisible(true);

	}
}
