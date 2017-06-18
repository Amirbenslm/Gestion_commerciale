package ControlerPack;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import classPack.Fournisseur;

public class FournisseurBase{
	ConnectionDataBase c=new ConnectionDataBase();
	Statement st;
	Connection con;
	
	public FournisseurBase()
	{
		
		c.loadDriver("com.mysql.jdbc.Driver");
		c.connect("jdbc:mysql://localhost:3306/gestioncommercial","root","");
	

	}
public Fournisseur AjoutFournisseur(Fournisseur f1)
{String req="INSERT INTO fournisseur(ref_fournisseur,raison_social,adresse,ville,matricule_fiscale,num_reg_commercial,num_tel) VALUES('"+f1.getReference()+"','"+f1.getRason_social()+"','"+f1.getAdresse()+"','"+f1.getVille()+"','"+f1.getMatricule_fiscale()+"','"+f1.getNum_reg_commerciale()+"','"+f1.getNum_tel()+"')";
String exsist="select * from fournisseur where ref_fournisseur='"+f1.getReference()+"'"+"and raison_social='"+f1.getRason_social()+"'"+"and adresse='"+f1.getAdresse()+"'"+"and matricule_fiscale='"+f1.getMatricule_fiscale()+"'"+"and num_reg_commercial='"+f1.getNum_reg_commerciale()+"'"+"and num_tel='"+f1.getNum_tel()+"'";
ResultSet existe=c.executeQuery(exsist);
try {
	if (existe.next())
		{JOptionPane.showMessageDialog(null," existe un fournisseur deja de même coordonnées !","Erreur",JOptionPane.ERROR_MESSAGE);
		return null;
		}
	else c.executeUpdate(req);
} catch (HeadlessException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
String rech="select max(id_fournisseur) from fournisseur where ref_fournisseur='"+f1.getReference()+"'"+"and raison_social='"+f1.getRason_social()+"'"+"and adresse='"+f1.getAdresse()+"'"+"and matricule_fiscale='"+f1.getMatricule_fiscale()+"'"+"and num_reg_commercial='"+f1.getNum_reg_commerciale()+"'"+"and num_tel='"+f1.getNum_tel()+"'";
	try {
	ResultSet rs=c.executeQuery(rech);
	rs.next();
	f1.setId(rs.getInt(1));
		System.out.println(rs.getInt(1));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return f1;
}


public int ModifierFournisseur(Fournisseur f1)
{String req="update  fournisseur set ref_fournisseur='"+f1.getReference()+"',raison_social ='"+f1.getRason_social()+"',adresse='"+f1.getAdresse()+"',ville='"+f1.getVille()+"',matricule_fiscale='"+f1.getMatricule_fiscale()+"',num_reg_commercial='"+f1.getNum_reg_commerciale()+"',num_tel='"+f1.getNum_tel()+"' where id_fournisseur="+f1.getId();
	
 int x=c.executeUpdate(req);
 if (x>0)
	 System.out.println("Done MAJ");
 else
	 System.out.println("Ereeure MAJ");
 return 2;	

}
public ResultSet affiche()
{ResultSet rs = null;
	//try {
	rs=c.executeQuery("select * from fournisseur");

	return rs ;
}
public ResultSet rechercheByID(int id)
{
	return c.executeQuery("select * from fournisseur where id_fournisseur="+id);
}
public ResultSet rechercheByReference(String s)
{
	return c.executeQuery("select * from fournisseur where ref_fournisseur='"+s+"'");
}
public ResultSet rechercheByVille(String s)
{
	return c.executeQuery("select * from fournisseur where ville='"+s+"'");
}
public void supprimerFourisseur(int id)
{String req="delete from fournisseur where id_fournisseur="+id;
	int a=c.executeUpdate(req);
	if(a<1)
		JOptionPane.showMessageDialog(null," Supprission echoué!","Erreur",JOptionPane.ERROR_MESSAGE);
	/*else
	JOptionPane.showMessageDialog(null,"Le Fournisseur!   "+id+" est supprimer","Erreur",JOptionPane.OK_OPTION);
*/}

/*public static void main(String []args)
{FournisseurBase f=new FournisseurBase();
f.affiche();
//f.supprimerFourisseur(3);	
ResultSet rs=f.rechercheByID(4);
try {
	while(rs.next())
		System.out.println(rs.getString(2));
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Fournisseur s=new Fournisseur(0,"Reference2", "rason_social", "adresse", "ville", "matricule_fiscale", "num_reg_commerciale", "num_tel");
f.AjoutFournisseur(s);

}*/

}
