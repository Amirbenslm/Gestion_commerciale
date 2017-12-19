import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import classPack.Client;
import classPack.Fournisseur;
import ControlerPack.ClientBase;
import ControlerPack.ConnectionDataBase;
import ControlerPack.FournisseurBase;


public class FournisseurJInternelFrame extends JInternalFrame  implements MouseListener{
	private JTextField textField;
	private JTable table;
	FournisseurBase db_fournisseur=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FournisseurJInternelFrame frame = new FournisseurJInternelFrame();
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
	public FournisseurJInternelFrame()  {
		
		setBounds(100, 100, 450, 300);
		db_fournisseur=new FournisseurBase();
		    this.setBorder(null);
			this.setResizable(true);
			this.setIconifiable(true);
			this.setClosable(true);
			this.setBounds(0, 0, 1198, 685);
			this.setVisible(true);
			
			this.getContentPane().setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Rechercher", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 191, 255)));
			panel_2.setBounds(10, 85, 370, 81);
			this.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(10, 25, 255, 28);
			panel_2.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton_4 = new JButton("");
			btnNewButton_4.setBounds(281, 25, 56, 26);
			panel_2.add(btnNewButton_4);
			
			
			table = new JTable();
			
			table.setModel(db_fournisseur.mytablemodel);
			table.addMouseListener(this);
			
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 171, 1178, 476);
			
	getContentPane().add(scrollPane);
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
	panel.setBounds(10, 2, 1178, 81);
	getContentPane().add(panel);
	panel.setLayout(null);

	JButton bajout = new JButton("Ajouter");
	bajout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			FournisseurAjout c=new FournisseurAjout(db_fournisseur);
			c.setVisible(true);
			
		}
	});
	bajout.setBounds(3, 3, 108, 74);
	panel.add(bajout);
	bajout.setBackground(SystemColor.controlHighlight);

	JButton bmodif = new JButton("Modifier");
    bmodif.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table.isRowSelected(table.getSelectedRow()))
			{
				Fournisseur fr =db_fournisseur.getFournisseur((int)table.getValueAt(table.getSelectedRow(), 0));
			 FournisseurMoudifier fm=new FournisseurMoudifier(db_fournisseur,fr);
				fm.setVisible(true);
			}
			else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
			
		}
	});
	bmodif.setBounds(108, 3, 108, 74);
	panel.add(bmodif);
	bmodif.setBackground(SystemColor.controlHighlight);

	JButton bsup = new JButton("Supprimer");
	bsup.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table.isRowSelected(table.getSelectedRow()))
			{int i=JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                    "Veuillez confirmer votre choix",
                    JOptionPane.YES_NO_OPTION);
			 	if(i==0){
				db_fournisseur.supprimerFourisseur(table.getSelectedRow());
			}}
			else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}
		
	});



	bsup.setBounds(214, 3, 108, 74);
	panel.add(bsup);
	bsup.setBackground(SystemColor.controlHighlight);

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2){
				System.out.println(table.getSelectedRow());
				
				Fournisseur fr =db_fournisseur.getFournisseur((int)table.getValueAt(table.getSelectedRow(), 0));
				 FournisseurMoudifier fm=new FournisseurMoudifier(db_fournisseur,fr);
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


