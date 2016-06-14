package cryptoproj1;

import java.io.*;
import java.math.BigInteger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
 
import javax.crypto.Cipher;


public class Client extends JFrame
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
	public static String e1=null;
	public static String msg=null;
	public static int i=0;
	int n;
	long end;
	
	public static void main(String [] Args)
	 {
		 new Client().setVisible(true);
		 
	 }
	void aes(String str) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException
	{
		String IV = "DEEPTIDEEPTIDEEP";	
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		KeyGenerator keyGen = KeyGenerator.getInstance("AES", "SunJCE");
		 keyGen.init(128);
		 Key key = keyGen.generateKey();
		cipher.init(Cipher.ENCRYPT_MODE,key,new IvParameterSpec(IV.getBytes("UTF-8")));
		byte[] str1 = cipher.doFinal(str.getBytes("UTF-8"));
		Server ss=new Server();
		ss.aes1(str1,IV,key);
	}
		public Client()
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
							
						    Server s=new Server();
						    try {
								s.login_req();
								System.out.println("Input your message to Bob:");
								BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					             msg= bufferRead.readLine();
								//Bi==gInteger r=s.rsa(str);
								try {
									aes(msg);
								} catch (InvalidKeyException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (NoSuchAlgorithmException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (NoSuchProviderException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (NoSuchPaddingException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (InvalidAlgorithmParameterException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IllegalBlockSizeException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (BadPaddingException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} catch (IOException e) {
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
								Server s1=new Server();
								try {
									s1.login_req();
								} catch (IOException e) {
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
									    Server s3=new Server();
									    try {
											s3.login_req();
										} catch (IOException e) {
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
