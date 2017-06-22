package ControlerPack;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import javax.swing.table.AbstractTableModel;
	import classPack.Article;
import classPack.Famille;
	public class FamilleModel  extends AbstractTableModel{
		int nblig;
		int id_famille,id_taxe;
		String nom_famille;
		Famille c;
		private java.sql.ResultSetMetaData rsmd;
		ArrayList <Famille> data=new ArrayList<Famille>();

  public FamilleModel(ResultSet rs) {
			// TODO Auto-generated constructor stub			
				try
				{
					rsmd=rs.getMetaData();
					while(rs.next())
					{
						nblig++;
						id_famille=rs.getInt(1);
						nom_famille=rs.getString(2);
						id_taxe=rs.getInt(3);
					//System.out.println(id_taxe);
					
						c=new Famille(id_famille,nom_famille,id_taxe);
						System.out.println(c.getId_taxe());
						data.add(c);
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
			}
			@Override
			public int getRowCount() {
				return nblig;
			}
			@Override
			public int getColumnCount() {
				try {
					return rsmd.getColumnCount();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
			}
			public String getColumnName(int l) {
				
				try {
					return rsmd.getColumnName(l+1);
				} catch (SQLException e) {
					
					e.printStackTrace();
					return null;
				}
			}
			@Override
			public Object getValueAt(int l, int c) {
							
				 Famille cl=data.get(l);
				if(c==0)
					{return cl.getId_fammille();
				  }
					if(c==1)
					{return cl.getNom_famille();	}
				if(c==2)
				{
					return cl.getId_taxe();
				}
				
				return("erreur");
				
			}
			public void supprimerLigne(int id){
				int ligne=RechercheBYID(id);
			data.remove(ligne);
			nblig --;
		    fireTableDataChanged();
				
			}
			public void AjouterLigne(Famille f){
				data.add(f);
				nblig ++;
			    fireTableDataChanged();	}
			
			public void ModifierLigne(Famille f)
			{int ligne=RechercheBYID(f.getId_fammille());
				data.set(ligne,f);
			fireTableDataChanged();
				
			}
			public int RechercheBYID(int id)
			{int i=0;
			Boolean b=false;
			while(i<data.size()&&(b==false))
			{System.out.println(i);
			if(data.get(i).getId_fammille()==id)
			{System.out.println(data.get(i).getId_fammille());
			b=true;
			}	
			i++;
			}
					return i-1;
			}
			}







