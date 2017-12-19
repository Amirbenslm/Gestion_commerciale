import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ControlerPack.FactureBase;
import classPack.Article;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class FactureInternelFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactureInternelFrame frame = new FactureInternelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	FactureBase	db_Facture =new FactureBase();
	/**
	 * Create the frame.
	 */
	public FactureInternelFrame() {
		setTitle("Facture");
		setBounds(100, 100, 450, 300);
		this.setBorder(null);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setBounds(0, 0, 1198, 685);
		this.setVisible(true);
		
		this.getContentPane().setLayout(null);
		table=new JTable();
		table.setModel(db_Facture.mytablemodel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 111, 1178, 521);
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
					new FactureModifier(db_Facture,db_Facture.mytablemodel.getFacture((int)db_Facture.mytablemodel.getValueAt(table.getSelectedRow(), 0))).setVisible(true);
				
			}
		});
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBounds(10, 2, 1178, 89);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FactureNouveau(db_Facture).setVisible(true);
			}
		});
		btnNouveau.setBounds(0, 6, 122, 78);
		panel.add(btnNouveau);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
					new FactureModifier(db_Facture,db_Facture.mytablemodel.getFacture((int)db_Facture.mytablemodel.getValueAt(table.getSelectedRow(), 0))).setVisible(true);

			}
			else
			{JOptionPane.showMessageDialog(null,"Il faut sélectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
		});
		btnModifier.setBounds(119, 6, 122, 78);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{int i=JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                        "Veuillez confirmer votre choix",
                        JOptionPane.YES_NO_OPTION);
				 	if(i==0){
					db_Facture.supprimerFacture(db_Facture.mytablemodel.getFacture((int)db_Facture.mytablemodel.getValueAt(table.getSelectedRow(), 0)).getId_facture());
					
			}}
			else
			{JOptionPane.showMessageDialog(null,"Il faut sélectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
			
			
		});
		btnSupprimer.setBounds(239, 6, 122, 78);
		btnNouveau.setBackground(SystemColor.controlHighlight);
		btnModifier.setBackground(SystemColor.controlHighlight);
		btnSupprimer.setBackground(SystemColor.controlHighlight);
		panel.add(btnSupprimer);

	}
}
