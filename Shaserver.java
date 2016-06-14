package cryptoproj1;

	import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

	import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

	public class Shaserver extends Shaclient
	{	
		static HashMap<String,String> hash = new HashMap<>();
		
		static
		{
		try {
			hash.put("Admin",sha1("admin"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hash.put("user1",sha1("user1"));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			hash.put("user2", sha1("user2"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		private static final long serialVersionUID = 1L;
		
		static String sha1(String input) throws NoSuchAlgorithmException {
	        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	        byte[] result = mDigest.digest(input.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        return sb.toString();
		}
		
		
		void login_req() throws HeadlessException, Exception
		{
			for(Entry<String,String> entry: hash.entrySet())
			{
			    if(text1.equals(entry.getKey()))
			    {
			    Object value = entry.getValue();
			    	if(sha1(text2).equals(value))
			    	{
			    	
			    	JOptionPane.showMessageDialog(null, "Login successful");
			    	System.exit(0);
			    	}
					else
					{
					System.out.println(sha1(text2));	
					JOptionPane.showMessageDialog(null,"Try again");
					i++;
					}	
					}
			    
				}
			}	
		}



