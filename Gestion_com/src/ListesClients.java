import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlerPack.ConnectionDataBase;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;

public class ListesClients extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm;
	private JScrollPane scrollPane;
	private JList<String> liste;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListesClients frame = new ListesClients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param id_doc 
	 * @param lbNomClient 
	 */
	public ListesClients(int id_doc, JLabel lbNomClient) {
		setTitle("Clients");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 150, 200, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		dlm=new DefaultListModel<String>();
		ResultSet rs=ConnectionDataBase.executeQuery("select * from client");
		
		try {
			while(rs.next())
			{dlm.addElement(rs.getInt(1)+" "+rs.getString("nom")+"   "+rs.getString("prenom"));
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		liste=new JList<>(dlm);
		liste.setBackground(Color.LIGHT_GRAY);
		liste.addMouseListener(new MouseListener() {
			
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
				if (e.getClickCount() == 2){
					lbNomClient.setText(liste.getSelectedValue());
				 StringTokenizer st = new StringTokenizer(liste.getSelectedValue(),"   ");  
			     String     id_client=st.nextToken();  
				ConnectionDataBase.executeUpdate("update document_vente set id_client ="+Integer.parseInt(id_client)+" where id_documentV ="+id_doc);
				
				dispose();
				}
				
			}
		});
		
		
		scrollPane = new JScrollPane(liste);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 30,199,335);
		contentPane.add(scrollPane);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(2, 8, 28, 21);
		contentPane.add(lblId);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(50, 11, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(110, 11, 46, 14);
		contentPane.add(lblPrenom);
	}
}
