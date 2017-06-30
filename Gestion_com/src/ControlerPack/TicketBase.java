package ControlerPack;



import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import classPack.Ticket;





public class TicketBase{

	public TicketModel mytablemodel;
	
	public TicketBase()
	{
		
		mytablemodel=new TicketModel(ConnectionDataBase.executeQuery("select * from ticket"));


	}
public boolean AjoutTicket(Ticket f1)
{String req="INSERT INTO ticket(ref_ticket,date,id_doc_vente,id_caissier) VALUES('"+f1.getReference()+"','"+f1.getDate()+"',"+f1.getId_doc_vente()+","+f1.getId_cassier()+")";
String rech="select max(id_ticket) from ticket where ref_ticket='"+f1.getReference()+"'"+"and date='"+f1.getDate()+"'"+"and id_doc_vente="+f1.getId_doc_vente()+" and id_caissier="+f1.getId_cassier();

try {
	ConnectionDataBase.executeUpdate(req);
	ResultSet rs=ConnectionDataBase.executeQuery(rech);
	rs.next();
	f1.setId_ticket(rs.getInt(1));
	mytablemodel.AjouterLigne(f1);
	
	} catch (HeadlessException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	return true;
}


public int ModifierTicket(Ticket f1)
{String req="update  ticket set ref_ticket='"+f1.getReference()+"',date='"+f1.getDate()+"',id_doc_vente="+f1.getId_doc_vente()+",id_caissier="+f1.getId_cassier()+" where id_ticket="+f1.getId_ticket();	
 int x=ConnectionDataBase.executeUpdate(req);
mytablemodel.ModifierLigne(f1);
 if (x>0)
	 System.out.println("Done MAJ");
 else
	 System.out.println("Ereeure MAJ");
 return x;	
}
public ResultSet affiche()
{ResultSet rs = null;
	rs=ConnectionDataBase.executeQuery("select * from ticket");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return ConnectionDataBase.executeQuery("select * from ticket where id_facture="+id);
}
public ResultSet rechercheByReference(String s)
{
	return ConnectionDataBase.executeQuery("select * from ticket where ref_ticket='"+s+"'");
}
public ResultSet rechercheByDate(String s)
{
	return ConnectionDataBase.executeQuery("select * from ticket where date like '"+s+"'");
}
public void supprimerTicket(int id)
{String req="delete from ticket where id_ticket="+id;
	int a=ConnectionDataBase.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	else
		mytablemodel.supprimerLigne(id);
}



}


