package cryptoproj1;

import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

import javax.swing.*;

public class Shaclient extends JFrame
{
	private static final long serialVersionUID=1L;
	
	/*Toolkit tk;*/
	Dimension dim;
	Container con;
	JLabel title,l1,l2,l3,l4,l;
	JLabel t1,s1,s2,s3;
	JTextField jtf1,jtf2;
	JPasswordField jpf1;
	JButton jbut1,jbut2;
	static String key;
	public static String text1=null;
	public static String text2=null;
	public static String text3=null;
	public static int i=0;
	int n;
	long end;
	
	public static void main(String [] Args)
	 {
		 new Shaclient().setVisible(true);
		 
	 }
		public Shaclient()
		{
			
			
			this.setTitle("LOGIN WINDOW");
			dim=Toolkit.getDefaultToolkit().getScreenSize();
			con=this.getContentPane();
			con.setBackground(Color.white);
			con.setLayout(null);
			
			s1=new JLabel(new ImageIcon("pictures//1.jpg"));
			s1.setBounds(0,0,900,684);
			con.add(s1);
			
			 t1=new JLabel("User Login");	    				
			 t1.setBounds(350,120,500,50);
			 t1.setForeground(Color.white);
			 t1.setFont(new Font("Times New Roman",Font.BOLD,40));
			 s1.add(t1);
            
			
			l1=new JLabel("User Name");
			l2=new JLabel("Password");
			l1.setForeground(Color.white);
			l1.setFont(new Font("Times New Roman",Font.BOLD,20));
			l2.setForeground(Color.white);
			l2.setFont(new Font("Times New Roman",Font.BOLD,20));
			
			jtf1=new JTextField();			
			jtf1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			jbut1=new JButton(new ImageIcon("pictures//b1.jpg"));
			jbut2=new JButton(new ImageIcon("pictures//b2.jpg"));
			
			jpf1=new JPasswordField();
			jpf1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			
			l1.setBounds(320,300,150,20);jtf1.setBounds(470,300,150,20);
			l2.setBounds(320,350,150,20);jpf1.setBounds(470,350,150,20);
			
			jbut1.setBounds(330,450,150,30);jbut2.setBounds(480,450,150,30);
			
		
			s1.add(l1);
			s1.add(jtf1);
			s1.add(l2);
			s1.add(jpf1);		
			s1.add(jbut1);
			s1.add(jbut2);
			
			this.setSize(905,720);
		     this.setLocation(50,20);
		     
		     
		     jbut1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						if(jtf1.getText().equals("")||jpf1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null,"Please enter username and password");
						}
						else
						{
							if(i<3)
							{
							text1=jtf1.getText();
							text2=jpf1.getText();
							
						    Shaserver s=new Shaserver();
						    try {
								s.login_req();
							} catch (HeadlessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    
							}
							else
							{
								if(i==3)
								{
								text3=jtf1.getText();
								JOptionPane.showMessageDialog(null,"More than 3 wrong attempts..please wait fo 2 mins","Message", JOptionPane.ERROR_MESSAGE);
								long start = System.currentTimeMillis();
								end = start + 180*1000;
								jtf1.setText("");
								jpf1.setText("");
								i++;
								}
								else
								{
								text1=jtf1.getText();
								text2=jpf1.getText();
								if(!(text1.equals(text3)))
								{
								Shaserver s1=new Shaserver();
								try {
									s1.login_req();
								} catch (HeadlessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								}
								else
								{
									if(System.currentTimeMillis() < end)
									{
									JOptionPane.showMessageDialog(null,"Please wait");
									System.out.println(end);
									}	
									else
									{
										text1=jtf1.getText();
										text2=jpf1.getText();
										i=0;
									    Shaserver s3=new Shaserver();
									    try {
											s3.login_req();
										} catch (HeadlessException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}	
									}
								}
							}
							}
						}
					}
				});
		     jbut2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						System.exit(0);
					}
				});
			
		}
}
