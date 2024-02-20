package enc_dec;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Transmit_data {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
	    kpg.initialize(1024);
	    KeyPair kp=kpg.generateKeyPair();
	    PrivateKey pvk=kp.getPrivate();
	    PublicKey pbk=kp.getPublic();
	    String conn_stat = null;
		ServerSocket ss=new ServerSocket(1234);		
		Socket s=new Socket("localhost",1234);
		DataOutputStream os=new DataOutputStream(s.getOutputStream());
		//os.writeUTF("blah!");
		os.write(enc("blah!",pbk));
		os.flush();
		os.close();
		s.close();
		Socket sa=ss.accept();
		DataInputStream is=new DataInputStream(sa.getInputStream());
		String str = null;
		//str=is.readUTF();
		byte[] b_data=new byte[os.size()];
		is.read(b_data);
		str=dec(b_data,pvk);
		if(s.isConnected()==true) {
			conn_stat="connected";
		}
		else {
			conn_stat="not connected";
		}
		ss.close();
		System.out.println(conn_stat+" "+str);
		System.out.println(new String(enc_h(str)));
	}
	public static byte[]enc(String data,PublicKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		byte[]e_data;
		Cipher cp =Cipher.getInstance("RSA");		
		cp.init(Cipher.ENCRYPT_MODE, key);
		e_data=cp.doFinal(data.getBytes());
		return e_data;
	}
	public static String dec(byte[]e_data,PrivateKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[]d_data;
		Cipher cp =Cipher.getInstance("RSA");		
		cp.init(Cipher.DECRYPT_MODE, key);
		d_data=cp.doFinal(e_data);
		return new String(d_data);
	}
	public static byte[] enc_h(String text) throws NoSuchAlgorithmException {
		MessageDigest md=MessageDigest.getInstance("SHA");
		md.update(text.getBytes());
		byte[] e_text=md.digest();
		return e_text;
	}

}
