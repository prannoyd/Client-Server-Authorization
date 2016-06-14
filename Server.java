package cryptoproj1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class Server extends Client
{
	BigInteger k1;
	BigInteger n1;
	BigInteger z1;
	BigInteger z2;
	
	void aes1(byte[] str1, String IV,Key key) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException
	{
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
	    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    String b1=new String(cipher.doFinal(str1),"UTF-8");
	    if(b1.contains(msg))
	    {
	    	System.out.println("Message received");
	    }
	    else
	    {
	    	System.out.println("Message not received");
	    }
	}
	public BigInteger rsa(String e) throws IOException
	{
        	Random random = new Random();
        	BigInteger biginteger = BigInteger.probablePrime(bigBit(), random);
            BigInteger biginteger1 = BigInteger.probablePrime(bigBit(), random);
             n1 = biginteger.multiply(biginteger1);
            BigInteger biginteger2 = biginteger.subtract(BigInteger.ONE).multiply(biginteger1.subtract(BigInteger.ONE));
			do
                k1 = BigInteger.probablePrime(smallBit(), random);
            while(!((BigInteger) k1).gcd(biginteger2).equals(BigInteger.ONE));
            Object d = ((BigInteger) k1).modInverse(biginteger2);
            System.out.println("Your public key: " + k1);
            return k1;
            
     }
	int bigBit()
    {
        Random random = new Random();
        byte byte0 = 20;
        byte byte1 = 26;
        return byte0 + random.nextInt((byte1 - byte0) + 1);
    }

    int smallBit()
    {
        Random random = new Random();
        byte byte0 = 7;
        byte byte1 = 13;
        return byte0 + random.nextInt((byte1 - byte0) + 1);
    }
    
	static HashMap<String, String> hash = new HashMap<>();
	
	static
	{
	hash.put("Admin", "admin");
	hash.put("user1", "user1");
	hash.put("user2", "user2");
	}
	private static final long serialVersionUID = 1L;
	void login_req() throws IOException
	{
		for(Entry<String, String> entry: hash.entrySet())
		{
		    if(text1.equals(entry.getKey()))
		    {
		    Object value = entry.getValue();
		    	if(text2.equals(value))
		    	{
		    	JOptionPane.showMessageDialog(null, "Login successful");
		    	//System.exit(0);
		    	}
				else
				{
				JOptionPane.showMessageDialog(null,"Try again");
				i++;
				}	
				}
		    
			}
		}	
	}

