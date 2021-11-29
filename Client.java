package wassim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Client extends JFrame
{
	public Client()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 100, 800, 600);	
		JLabel l1=new JLabel("CLIENT");
		JLabel l2=new JLabel("DONNE VOTRE ID DE CLIENT :");
		JLabel l3=new JLabel("DONNE VOTRE PRENOM DE CLIENT :");
		JLabel l4=new JLabel("DONNE VOTRE NOM DE CLIENT :");
		JLabel l5=new JLabel("DONEE VOTRE VILLE DE CLIENT :");
		JLabel l6=new JLabel("DONNE VOTRE NUMERO TELEPHONE DE CLIENT :");
		JLabel l7=new JLabel("DONNE VOTRE TRAVAIL  DE CLIENT :");
		JLabel l8=new JLabel("DONNE VOTRE ADRESSE EXACTE  DE CLIENT :");
		TextField t1=new TextField(10);
		TextField t2=new TextField(10);
		TextField t3=new TextField(10);
		TextField t4=new TextField(10);
		TextField t5=new TextField(10);
		String [] Element=new String[]{"Ariana","B�ja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","La Manouba","Le Kef","Mahdia","M�denine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"
};
		JComboBox c1=new JComboBox(Element);
		String [] Element1=new String[]{"Acheteur","Administrateur de base de donn�es","Agent de s�ret� a�roportuaire","Agent de transit","Agent d'entretien","Agent fun�raire","Agent immobilier","Agent de police","Agent de presse","Agent de s�curit�","Agent de surveillance de la voie publique (ASVP)","Agronome","Ambulancier","Analyste financier","Analyste programmeur","Analyste Web","Architecte","Architecte paysagiste","Architecte en syst�me d'information","Archiviste","Assitant administratif et financier","Assistant bliblioth�caire","Assistant d'�ducation","Assistant dentaire","Assistant marketing","Assistant paie et administration","Assistant RH","Assureur","Audioproth�siste","Auditeur financier","Auxiliaire de pu�riculture","Auxiliaire de vie sociale","Avocat","Biblioth�caire","Biologiste","Charg� de communication","Charg� de recrutement","Charpentier","Chauffeur de taxi","Chefs de chantier","Chef de projet","Chef de projet marketing","Chef d'�tablissement","Chiropracteur","Chirurgien orthop�diste",
"Coiffeur","Commis de cuisine","Comptable","Concepteur de jeux vid�os","Concepteur-r�dacteur","Conducteur de grue","Conducteur de train","Conseiller","Conseiller d'orientation","Conseiller en insertion professionnelle","Consultant bien-�tre","Consultant en informatique","Contr�leur (trains)","Contr�leur a�rien","Contr�leur de gestion","Contr�leur financier","Courtier en assurance","Cuisinier","D�corateur d'int�rieur",
"Dentiste","Designer industriel","D�veloppeur informatique","Diacre","Di�t�ticien","Directeur artistique","Directeur des ventes","Directeur financier","Directeur RH","Economiste","Educateur de jeunes","Eleveur","Employ� de banque","Enseignant","Ergoth�rapeute","Esth�ticienne","Fleuriste","Gardien","G�om�tre","Gestionnaire immobilier","H�tesse de l'air","Huissier","Illustrateur","Infirmi�re","Ing�nieur civil","Ing�nieur �lectronicien","Ing�nieur du BTP","Inspecteur de l'action sanitaire et sociale","Jardinier","Jardinier paysagiste","Journaliste","Juge","Kin�sith�rapeute","Linguiste","Machiniste","Magasinier","Ma�tre d'h�tel","Manipulateur radio","Masseur","M�canicien a�ronautique","M�decin","Moniteur d'auto-�cole","Monteur �lectricien","Nutritionniste","Officier","Op�rateur de production","Op�rateur d'usinage sur commande num�rique (UCN)","Opticien","Orthophoniste","Personal Trainer","Pharmacien","Photographe","Physicien","Physicien m�dical","Pilote","Politicien","Pompier","Poseur de sol (solier)","Pr�tre","Procureur","Professeur des �coles","Professeur d'�ducation physique (EPS)","Professeur de fran�ais langue �trang�re","Porfesseur des universit�s","Psychologue","R�ceptionniste","R�ceptionniste d'h�tel","Responsable communication","Responsable grands comptes","Responsable service client�le","Sages-femmes","Secr�taire m�dicale","Serveur","Skipper","Soldat","Soudeur","Statisticien","Surveillant p�nitentiaire","Technicien alarme intrusion","Technicien d'analyses biom�dicales","Technicien de maintenance informatique","Technicien d'exploitation","T�l�conseiller","Test manager","Travailleur social","Urbaniste","Vendeur","V�t�rinaire","Webmaster",

};
		JComboBox c2=new JComboBox(Element1);
		JButton b1=new JButton("Ajouter");
		JButton b2=new JButton("Modifier");
		JButton b3=new JButton("Supprimer");
		JButton b4=new JButton("Quitter");
		JButton b5=new JButton("Vider");
		t1.addTextListener(new TextListener()
				{
					public void textValueChanged(TextEvent arg0) 
					{
						if(t1.getText()!="")
						{
							Connection conn=null;
							Statement stmt=null;
							ResultSet rs=null;
							
							try 
							{
								Class.forName("oracle.jdbc.driver.OracleDriver");
							} catch (ClassNotFoundException e) 
							{
								e.printStackTrace();
							}
							
							String req="Select * from clientt where id="+t1.getText();
							
							try 
							{
								conn=DriverManager.getConnection("jdbc:oracle:thin:@wassim-PC:1521:xe","wassim","53592755");
								stmt=conn.createStatement();
								rs=stmt.executeQuery(req);
								
								while(rs.next())
								{
									t2.setText(rs.getString("prenom"));
									t3.setText(rs.getString("nom"));
									c1.setSelectedItem(rs.getString(3));
									t4.setText(rs.getString("telephone"));
									c2.setSelectedItem(rs.getString(3));
									t5.setText(rs.getString("adresse"));
								}
								
								rs.close();
								stmt.close();
								conn.close();
							} 
							catch (SQLException e) 
							{
								e.printStackTrace();
							}
						}
						
					}
			
				});
		
		b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						Connection conn=null;
						PreparedStatement pstmt=null;
						
						try 
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
						} catch (ClassNotFoundException e) 
						{
							e.printStackTrace();
						}
						
						String req="insert into clientt values ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+c1.getSelectedItem().toString()+"','"+t4.getText()+"','"+c2.getSelectedItem().toString()+"','"+t5.getText()+"')";
						
						try 
						{
							conn=DriverManager.getConnection("jdbc:oracle:thin:@wassim-PC:1521:xe","wassim","53592755");
							pstmt=conn.prepareStatement(req);
							pstmt.executeQuery();
							
							pstmt.close();
							conn.close();
						} 
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
						
					}
			
				});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				
				String req="update clientt set prenom='"+t2.getText()+"',nom='"+t3.getText()+"', ville='"+c1.getSelectedItem().toString()+"',telephone='"+t4.getText()+"',travail='"+c2.getSelectedItem().toString()+"',adresse='"+t5.getText()+"' where id="+t1.getText()+"";
				
				try 
				{
					conn=DriverManager.getConnection("jdbc:oracle:thin:@wassim-PC:1521:xe","wassim","53592755");
					pstmt=conn.prepareStatement(req);
					pstmt.executeQuery();
					
					pstmt.close();
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
	
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				
				String req="Delete from clientt where id="+t1.getText()+"";
				
				try 
				{
					conn=DriverManager.getConnection("jdbc:oracle:thin:@wassim-PC:1521:xe","wassim","53592755");
					pstmt=conn.prepareStatement(req);
					pstmt.executeQuery();
					
					pstmt.close();
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
	
		});
		b5.addActionListener(new ActionListener()
		{


			public void actionPerformed(ActionEvent e) {
				t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			
			}
	
		});
b4.addActionListener(new ActionListener ()
		{

			
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);	
			}
		});
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		
		FlowLayout fl=new FlowLayout();
		
		GridLayout gl1=new GridLayout(7,2);
		
		p1.setLayout(gl1);
		
		p1.add(l2);
		p1.add(t1);
		p1.add(l3);
		p1.add(t2);
		p1.add(l4);
		p1.add(t3);
		p1.add(l5);
		p1.add(c1);
		p1.add(l6);
		p1.add(t4);
		p1.add(l7);
		p1.add(c2);
		p1.add(l8);
		p1.add(t5);
		
		p2.setLayout(fl);
		
		p2.add(p1);
		
		p3.setLayout(fl);
		
			p3.add(b1);
			p3.add(b2);
			p3.add(b3);
			p3.add(b5);
			p3.add(b4);;
		GridLayout gl2=new GridLayout(3,1);
		
		p4.setLayout(gl2);
		
		p4.add(l1);
		p4.add(p2);
		p4.add(p3);
		
		this.add(p4);

	}
}