package wassim;
		import javax.swing.*;
		import java.awt.*;
		import java.awt.event.*;
		import java.sql.*;
		public class Login 
		{
			public static void main(String[] args) {
				{
					JFrame Login=new JFrame("LOGIN");
	 		
					Login.getContentPane().setBackground(Color.green);
					Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
						Login.setBounds(450, 150, 450, 450);
				
						JLabel l1=new JLabel("LOGIN");
						
						    JLabel l2=new JLabel("user  name :");
						JLabel l3=new JLabel(" user pass word : ");
						
						TextField t1=new TextField(10);
						JPasswordField t2=new JPasswordField(10);
				
						JButton b1=new JButton("LOGIN");
						JButton b2=new JButton("QUITER");
						JPanel p1=new JPanel();
						JPanel p2=new JPanel();
						JPanel p3=new JPanel();
						JPanel p4=new JPanel();
						l1.setHorizontalAlignment(JLabel.CENTER);
				FlowLayout fl=new FlowLayout();
						
						GridLayout gl1=new GridLayout(3,2);
						p1.setLayout(gl1);
						p1.add(l2);
						p1.add(t1);
						p1.add(l3);
						p1.add(t2);
				p2.setLayout(fl);
						
						p2.add(p1);
						
						p3.setLayout(fl);
						
							p3.add(b1);
							p3.add(b2);
							GridLayout gl2=new GridLayout(3,1);
							p4.setLayout(gl2);
							
							p4.add(l1);
							p4.add(p2);
							p4.add(p3);
							b1.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent arg0) {
											Connection conn=null;
											PreparedStatement pstmt=null;
											ResultSet rs=null;
											
											try 
											{
												Class.forName("oracle.jdbc.driver.OracleDriver");
											} catch (ClassNotFoundException e) 
											{
												e.printStackTrace();
											}
											
											
										try 
										{
											
											conn=DriverManager.getConnection("jdbc:oracle:thin:@wassim-PC:1521:XE","wassim","53592755");
											String req="select * from loginc where name = ?  and  password = ? ";
											pstmt=conn.prepareStatement(req);
											pstmt.setString(1, t1.getText());
											pstmt.setString(2, t2.getText());
											rs=pstmt.executeQuery();
											if(rs.next())
											{
							
												Client c1=new Client();
												c1.setVisible(true);
											}
											else
											{
												JOptionPane.showMessageDialog(null, " ! ATTENTION !  :veuillez  valider le  user name ou user password");
												t1.setText("");
												t2.setText("");
											}
						 					pstmt.close();
											conn.close();
											
										} 
									
										
										catch (SQLException e) 
										{
											e.printStackTrace();
										}
										}
									});
							b2.addActionListener(new ActionListener ()
							{

								
								public void actionPerformed(ActionEvent arg0) {
								System.exit(0);	
								}
							});
						Login.add(p4); 
						Login.show();
						
		
			}
				
					
				}	
			}
			

