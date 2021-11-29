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
		String [] Element=new String[]{"Ariana","Béja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","La Manouba","Le Kef","Mahdia","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"
};
		JComboBox c1=new JComboBox(Element);
		String [] Element1=new String[]{"Acheteur","Administrateur de base de données","Agent de sûreté aéroportuaire","Agent de transit","Agent d'entretien","Agent funéraire","Agent immobilier","Agent de police","Agent de presse","Agent de sécurité","Agent de surveillance de la voie publique (ASVP)","Agronome","Ambulancier","Analyste financier","Analyste programmeur","Analyste Web","Architecte","Architecte paysagiste","Architecte en système d'information","Archiviste","Assitant administratif et financier","Assistant blibliothécaire","Assistant d'éducation","Assistant dentaire","Assistant marketing","Assistant paie et administration","Assistant RH","Assureur","Audioprothésiste","Auditeur financier","Auxiliaire de puériculture","Auxiliaire de vie sociale","Avocat","Bibliothécaire","Biologiste","Chargé de communication","Chargé de recrutement","Charpentier","Chauffeur de taxi","Chefs de chantier","Chef de projet","Chef de projet marketing","Chef d'établissement","Chiropracteur","Chirurgien orthopédiste",
"Coiffeur","Commis de cuisine","Comptable","Concepteur de jeux vidéos","Concepteur-rédacteur","Conducteur de grue","Conducteur de train","Conseiller","Conseiller d'orientation","Conseiller en insertion professionnelle","Consultant bien-être","Consultant en informatique","Contrôleur (trains)","Contrôleur aérien","Contrôleur de gestion","Contrôleur financier","Courtier en assurance","Cuisinier","Décorateur d'intérieur",
"Dentiste","Designer industriel","Développeur informatique","Diacre","Diététicien","Directeur artistique","Directeur des ventes","Directeur financier","Directeur RH","Economiste","Educateur de jeunes","Eleveur","Employé de banque","Enseignant","Ergothérapeute","Esthéticienne","Fleuriste","Gardien","Géomètre","Gestionnaire immobilier","Hôtesse de l'air","Huissier","Illustrateur","Infirmière","Ingénieur civil","Ingénieur électronicien","Ingénieur du BTP","Inspecteur de l'action sanitaire et sociale","Jardinier","Jardinier paysagiste","Journaliste","Juge","Kinésithérapeute","Linguiste","Machiniste","Magasinier","Maître d'hôtel","Manipulateur radio","Masseur","Mécanicien aéronautique","Médecin","Moniteur d'auto-école","Monteur électricien","Nutritionniste","Officier","Opérateur de production","Opérateur d'usinage sur commande numérique (UCN)","Opticien","Orthophoniste","Personal Trainer","Pharmacien","Photographe","Physicien","Physicien médical","Pilote","Politicien","Pompier","Poseur de sol (solier)","Prêtre","Procureur","Professeur des écoles","Professeur d'éducation physique (EPS)","Professeur de français langue étrangère","Porfesseur des universités","Psychologue","Réceptionniste","Réceptionniste d'hôtel","Responsable communication","Responsable grands comptes","Responsable service clientèle","Sages-femmes","Secrétaire médicale","Serveur","Skipper","Soldat","Soudeur","Statisticien","Surveillant pénitentiaire","Technicien alarme intrusion","Technicien d'analyses biomédicales","Technicien de maintenance informatique","Technicien d'exploitation","Téléconseiller","Test manager","Travailleur social","Urbaniste","Vendeur","Vétérinaire","Webmaster",

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