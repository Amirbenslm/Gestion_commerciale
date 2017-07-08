import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;
import ControlerPack.FamilleBase;
import classPack.Famille;
import classPack.Taxe;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Familles extends JFrame implements MouseListener {

	private JPanel contentPane;
	FamilleBase db_famille=null;
	JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Familles frame = new Familles();
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
	public Familles() {
		
		
		db_famille=new FamilleBase();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table= new JTable();
		table.setModel(db_famille.mytablemodel);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 57, 463, 179);
		contentPane.add(scrollPane);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FamilleAjout familleAjout=new FamilleAjout(db_famille);
				familleAjout.setVisible(true);
			}
		});
		btnAjouter.setBounds(169, 258, 91, 33);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Famille f1= db_famille.getFamille((int) db_famille.mytablemodel.getValueAt(table.getSelectedRow(),0));
				FamilleModifier fm=new FamilleModifier(db_famille, f1);
				fm.setVisible(true);
			
			}
			else
		{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne ou bien Double click sur la ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
	
		}
		});
		btnModifier.setBounds(268, 258, 91, 33);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				
				db_famille.supprimerFamille((int)db_famille.mytablemodel.getValueAt(table.getSelectedRow(),0));
				
			
			}
			else
		{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
	
		}
			
		});
		btnSupprimer.setBounds(367, 258, 101, 33);
		contentPane.add(btnSupprimer);
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
if (e.getClickCount() == 2){
			
	Famille f1= db_famille.getFamille((int) db_famille.mytablemodel.getValueAt(table.getSelectedRow(),0));
	FamilleModifier fm=new FamilleModifier(db_famille, f1);
	fm.setVisible(true);
		}
		
	}
		
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
