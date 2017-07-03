import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ControlerPack.ConnectionDataBase;
import ControlerPack.TaxeBase;
import ControlerPack.TaxeModel;
import classPack.Taxe;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Taxes extends JFrame implements MouseListener {
	public TaxeBase db_taxe;
	private JPanel contentPane;
	JTable table;
	public static  TaxeModel model;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taxes frame = new Taxes();
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
	public Taxes()  {
		ConnectionDataBase.loadDriver("com.mysql.jdbc.Driver");
		ConnectionDataBase.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
		setTitle("Taxes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 367);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 db_taxe=new TaxeBase();
		 table=new JTable();
		 model=db_taxe.mytablemodel;
		table.setModel(model);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(43, 37, 572, 202);
		contentPane.add(scrollPane);
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxeAjout ta=new TaxeAjout();
				ta.setVisible(true);
			}
		});
		Ajouter.setBounds(288, 270, 91, 31);
		contentPane.add(Ajouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.isRowSelected(table.getSelectedRow()))
				{
				Taxe taxe= db_taxe.getTaxe(table.getSelectedRow());
				TaxeModifier tm=new TaxeModifier(taxe);
				tm.setVisible(true);
			}
				else
			{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne ou bien Double click sur la ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
		}});
		btnModifier.setBounds(404, 270, 91, 31);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.isRowSelected(table.getSelectedRow()))
				{
					
					db_taxe.supprimerTaxe((int)db_taxe.mytablemodel.getValueAt(table.getSelectedRow(),0));
				}
				else
				{JOptionPane.showMessageDialog(null,"Il faut selectionner une ligne!","Erreur",JOptionPane.ERROR_MESSAGE);}
			}
		});
		btnSupprimer.setBounds(520, 270, 98, 31);
		contentPane.add(btnSupprimer);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2){
			
			Taxe taxe= db_taxe.getTaxe(table.getSelectedRow());
			TaxeModifier tm=new TaxeModifier(taxe);
			tm.setVisible(true);
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
